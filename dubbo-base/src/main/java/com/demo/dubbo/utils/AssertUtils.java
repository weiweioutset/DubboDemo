package com.demo.dubbo.utils;

import com.demo.dubbo.enums.CommonExceptionEnum;
import com.demo.dubbo.exception.CommonException;
import org.apache.dubbo.common.utils.Assert;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/27 上午10:04
 * @desc
 */
public class AssertUtils {
    private static final CommonException INVALID_PARAMS = new CommonException(CommonExceptionEnum.INVALID_PARAMS);

    /**
     * 判断参数是否为null
     * @param object
     */
    public static void notNull(Object object) {
        Assert.notNull(object, INVALID_PARAMS);
    }

    /**
     * 判断参数是否为null
     * @param objects
     */
    public static void notNull(Object...objects) {
        for (Object object : objects) {
            Assert.notNull(object, INVALID_PARAMS);
        }
    }

    /**
     * 判断参数是否为null
     * @param object
     * @param exceptionEnum
     */
    public static void notNull(Object object, CommonExceptionEnum exceptionEnum) {
        Assert.notNull(object, new CommonException(exceptionEnum));
    }
}
