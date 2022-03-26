package com.demo.dubbo.utils;

import com.demo.dubbo.constant.RedisKeyConstant;
import com.demo.dubbo.dto.LoginInfo;
import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/26 上午10:33
 * @desc 用户登录相关工具类
 */
@Component
public class UserLoginUtils {
    @Autowired
    private RedisUtils redisUtils;

    private static UserLoginUtils bean;

    @PostConstruct
    public void init() {
        bean = this;
        bean.redisUtils = this.redisUtils;
    }

    public static boolean login(HttpServletResponse response, UserDto user) {
        // 生成token
        String token = TokenUtils.generateToken(user);
        // 将token写入header
        response.addHeader("token", token);
        // 将用户身份信息缓存
        LoginInfo loginInfo = LoginInfo.init(user);
        bean.redisUtils.setValue(RedisKeyConstant.USER_TOKEN_KEY + token, loginInfo, 110L, TimeUnit.MINUTES);
        // todo 记录登录ip
        return true;
    }

    /**
     * 获取登录信息
     * @return
     */
    public static LoginInfo loginInfo() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 先从参数中获取token
        String token = request.getParameter("token");
        if (StringUtil.isEmpty(token)) {
            // 如果参数中没有token，再从header中过去
            token = request.getHeader("token");
        }
        if (StringUtil.isEmpty(token)) {
            throw new CommonException(CommonExceptionEnum.NO_LOGIN);
        }
        LoginInfo loginInfo = (LoginInfo) bean.redisUtils.getValue(RedisKeyConstant.USER_TOKEN_KEY + token);
        if (loginInfo == null) {
            throw new CommonException(CommonExceptionEnum.NO_LOGIN);
        }
        return loginInfo;
    }
}
