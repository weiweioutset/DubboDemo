package com.demo.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午3:52
 * @desc
 */
@EnableDubbo
@SpringBootApplication
public class DubboUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboUserApplication.class, args);
    }
}
