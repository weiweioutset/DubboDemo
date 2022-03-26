package com.demo.dubbo.interceptor;

import com.demo.dubbo.annotation.PublicAPI;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import com.demo.dubbo.utils.StringUtil;
import com.demo.dubbo.utils.TokenUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/26 上午10:11
 * @desc 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        PublicAPI publicAPI = handlerMethod.getMethodAnnotation(PublicAPI.class);
        if (publicAPI != null) {
            return true;
        }
        // 先从参数中获取token
        String token = request.getParameter("token");
        if (StringUtil.isEmpty(token)) {
            // 如果参数中没有token，再从header中过去
            token = request.getHeader("token");
        }
        if (StringUtil.isEmpty(token)) {
            throw new CommonException(CommonExceptionEnum.NO_LOGIN);
        }
        // 校验token是否有效
        TokenUtils.verifyToken(token);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}