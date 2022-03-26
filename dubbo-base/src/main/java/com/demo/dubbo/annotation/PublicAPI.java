package com.demo.dubbo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/25 下午8:55
 * @desc 公共API，用于对外开放的接口，不用检验权限
 */
@Target({ElementType.METHOD, ElementType.TYPE})// 可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface PublicAPI {

}
