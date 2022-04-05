package com.demo.dubbo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/25 下午9:19
 * @desc 设备工具类
 */
public class DeviceUtils {

    /**
     * 获取设备id
     * @return
     */
    public static String getDeviceId() {
        return "device";
    }

    /**
     * 获取设备的ip
     * @return
     */
    public static String getDeviceIp() {
        return "192.168.1.1";
    }
}
