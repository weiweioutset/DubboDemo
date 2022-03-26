package com.demo.dubbo.controller;

import org.apache.dubbo.rpc.RpcContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/26 下午2:30
 * @desc
 */
public class BaseController {

    public HttpServletRequest getRequest() {
        return (HttpServletRequest) RpcContext.getContext().getRequest();
    }

    public HttpServletResponse getResponse() {

        return (HttpServletResponse) RpcContext.getServerContext().getResponse();
    }
}
