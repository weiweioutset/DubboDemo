package com.demo.dubbo.utils;

import com.demo.dubbo.dto.UserDto;
import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/24 下午10:25
 * @desc 用户安全相关
 */
public class UserSecurityUtils {
    public static boolean checkPassword(String password, UserDto userDto) throws CommonException {
        if (StringUtil.isEmpty(password) || userDto == null) {
            return false;
        }
        String userPassword = userDto.getPassword();
        userDto.setPassword(null);
        // 对前端加密后的密码进行解密
        try {
            password = RSAUtils.privateKeyDecrypt(password);
        } catch (Exception e) {
            throw new CommonException(CommonExceptionEnum.SYSTEM_ERROR);
        }
        // 判断密码是否正确
        String encryptPwd = SecurityUtils.RSAEncrypt(password);
        if (encryptPwd != null && encryptPwd.equals(userPassword)) {
            return true;
        } else {
            throw new CommonException(CommonExceptionEnum.PASSWORD_ERROR);
        }
    }
}
