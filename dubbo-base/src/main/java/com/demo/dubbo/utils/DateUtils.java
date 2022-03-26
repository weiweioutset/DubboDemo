package com.demo.dubbo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/25 下午9:49
 * @desc 时间处理工具
 */
public class DateUtils {

    /**
     * 获取未来的时间
     * @param millSeconds 距离现在的毫秒数
     * @return
     */
    public static Date getFutureTime(long millSeconds) {
        if (millSeconds <= 0) {
            throw new IllegalArgumentException("必须为正整数");
        }
        return new Date(System.currentTimeMillis() + millSeconds);
    }

    public static void main(String[] args) {
        Date date = getFutureTime(1L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
        System.out.println(simpleDateFormat.format(date));
    }
}
