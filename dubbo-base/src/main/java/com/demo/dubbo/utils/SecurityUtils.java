package com.demo.dubbo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:18
 * @desc 安全相关工具类
 */
public class SecurityUtils {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);
    private static final String DES_ENCRYPT_KEY = "A#B2C3D4E5F6070*CG=54/87";

    /**
     * RSA加密(私钥)
     * @param content
     * @return
     */
    public static String RSAEncrypt(String content) {
        if (StringUtil.isEmpty(content)) {
            return null;
        }
        try {
            return RSAUtils.privateKeyEncrypt(content);
        } catch (Exception e) {
            logger.error("RSA加密失败", e);
        }
        return content;
    }

    /**
     * RSA解密(公钥)
     * @param content
     * @return
     */
    public static String RSADecrypt(String content) {
        if (StringUtil.isEmpty(content)) {
            return null;
        }
        try {
            return RSAUtils.publicKeyDecrypt(content);
        } catch (Exception e) {
            logger.error("RSA解密失败", e);
        }
        return content;
    }

    /**
     * DES对称加密
     * @param content 原文
     * @return 密文
     */
    public static String DESEncrypt(String content) {
        if (StringUtil.isEmpty(content)) {
            return null;
        }
        try {
            return DESUtil.encrypt(content, DES_ENCRYPT_KEY);
        } catch (Exception e) {
            logger.error("DES加密错误", e);
        }
        return content;
    }

    /**
     * DES对称加密
     * @param content 原文
     * @return 密文
     */
    public static String DESDecrypt(String content) {
        if (StringUtil.isEmpty(content)) {
            return null;
        }
        try {
            return DESUtil.decrypt(content, DES_ENCRYPT_KEY);
        } catch (Exception e) {
            logger.info("DES解密失败");
        }
        return null;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) throws Exception{
        String pwd = "1459058344";
        String p = RSAEncrypt(pwd);
        String w = RSADecrypt(p);

        System.out.println("p = " + p + "\nw = " + w);
    }
}
