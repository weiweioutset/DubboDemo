package com.demo.dubbo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:18
 * @desc 安全相关工具类
 */
public class SecurityUtils {
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

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

    public static void main(String[] args) throws Exception{
        String pwd = "1459058344";
        String p = RSAEncrypt(pwd);
        String w = RSADecrypt(p);

        System.out.println("p = " + p + "\nw = " + w);
    }
}
