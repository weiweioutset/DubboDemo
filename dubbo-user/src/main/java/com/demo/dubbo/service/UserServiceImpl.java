package com.demo.dubbo.service;

import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import com.demo.dubbo.service.user.IUserService;
import com.demo.dubbo.utils.RSAUtils;
import com.demo.dubbo.utils.SecurityUtils;
import com.demo.dubbo.utils.StringUtil;
import com.sun.istack.internal.NotNull;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:00
 * @desc 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public UserDto register(@NotNull UserDto user) throws CommonException {
        // 参数校验
        if (StringUtil.isEmpty(user.getPassword())) {
            throw new CommonException(CommonExceptionEnum.PASSWORD_INVALID);
        }
        // 对前端加密后的密码进行解密
        String password;
        try {
            password = RSAUtils.privateKeyDecrypt(user.getPassword());
        } catch (Exception e) {
            throw new CommonException(CommonExceptionEnum.SYSTEM_ERROR);
        }
        // 然后再使用私钥加密
        String encryptPwd = SecurityUtils.RSAEncrypt(password);
        // todo 对电话和邮箱进行加密
        user.setPassword(encryptPwd);

        return user;
    }

    @Override
    public UserDto login(String accountId, String password) throws CommonException {
        return null;
    }

    @Override
    public UserDto update(UserDto user) throws CommonException {
        return null;
    }

    @Override
    public int cancelAccount(String accountId) throws CommonException {
        return 0;
    }
}
