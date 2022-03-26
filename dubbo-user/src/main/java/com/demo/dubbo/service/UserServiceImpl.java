package com.demo.dubbo.service;

import com.demo.dubbo.constant.BaseConstant;
import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import com.demo.dubbo.mapper.UserMapper;
import com.demo.dubbo.service.user.IUserService;
import com.demo.dubbo.utils.*;
import com.sun.istack.internal.NotNull;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:00
 * @desc 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto register(@NotNull UserDto user) throws CommonException {
        // 参数校验
        if (StringUtil.isEmpty(user.getPassword())) {
            throw new CommonException(CommonExceptionEnum.PASSWORD_INVALID);
        }
        // 首先检查账号是否存在
        UserDto userDto = userMapper.queryByAccountId(user.getAccountId());
        if (userDto != null) {
            throw new CommonException(CommonExceptionEnum.ACCOUNT_ALREADY_EXIST);
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
        user.setPassword(encryptPwd);
        // 对电话号码和邮箱进行加密
        user.setPhone(SecurityUtils.DESEncrypt(user.getPhone()));
        user.setEmail(SecurityUtils.DESEncrypt(user.getEmail()));
        String uuid = SecurityUtils.getUUID();
        user.setUuid(uuid);
        user.setStatus(0);
        userMapper.register(user);
        return user;
    }

    @Override
    public UserDto login(String accountId, String password) {
        UserDto userDto = userMapper.queryByAccountId(accountId);
        if (userDto == null || userDto.getStatus() == null || userDto.getStatus() == BaseConstant.USER_STATUS_DELETE) {
            throw new CommonException(CommonExceptionEnum.ACCOUNT_NOT_EXIST);
        }
        // 判断账号状态
        if (userDto.getStatus() == BaseConstant.USER_STATUS_APPLY) {
            throw new CommonException(CommonExceptionEnum.ACCOUNT_NOT_ENABLE);
        }
        if (userDto.getStatus() == BaseConstant.USER_STATUS_BLOCK) {
            throw new CommonException(CommonExceptionEnum.ACCOUNT_BE_BLOCKED);
        }
        // 判断密码是否正确
        if (!UserSecurityUtils.checkPassword(password, userDto)) {
            throw new CommonException(CommonExceptionEnum.LOGIN_ERROR);
        }
        logger.info("用户[{}]登录成功", userDto.getAccountId());
        return userDto;
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
