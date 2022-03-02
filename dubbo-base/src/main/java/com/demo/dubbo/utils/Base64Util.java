package com.demo.dubbo.utils;

import org.springframework.util.Base64Utils;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午9:42
 * @desc
 */
public class Base64Util {
    /**
     * Base64加密
     */
    public static String encryptBASE64(byte[] key) {
        return Base64Utils.encodeToString(key);
    }

    /**
     * Base64解密
     */
    public static byte[] decryptBASE64(String key) {
        return Base64Utils.decodeFromString(key);
    }
}
