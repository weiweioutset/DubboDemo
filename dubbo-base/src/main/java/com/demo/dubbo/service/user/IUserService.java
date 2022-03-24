package com.demo.dubbo.service.user;

import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.exception.CommonException;


/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午3:59
 * @desc
 */
public interface IUserService {
    /**
     * 注册账号
     * @param user
     * @return
     */
    UserDto register(UserDto user) throws CommonException;

    /**
     * 登录
     * @param accountId
     * @param password
     * @return
     */
    UserDto login(String accountId, String password);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    UserDto update(UserDto user) throws CommonException;

    /**
     * 注销账号
     * @param accountId
     * @return
     */
    int cancelAccount(String accountId) throws CommonException;
}
