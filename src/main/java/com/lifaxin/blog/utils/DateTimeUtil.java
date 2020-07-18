package com.lifaxin.blog.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 日期工具
 * @Author LiFaXin
 * @Date 2020/7/11 17:54
 * @Version
 **/
public class DateTimeUtil {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDateTimeStr(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(fmt);
    }
}
