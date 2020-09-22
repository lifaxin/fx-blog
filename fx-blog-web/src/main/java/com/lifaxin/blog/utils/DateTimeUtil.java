package com.lifaxin.blog.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @Description 日期工具
 * @Author LiFaXin
 * @Date 2020/7/11 17:54
 * @Version
 **/
public class DateTimeUtil {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static ZoneId zoneId = ZoneId.systemDefault();

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDateTimeStr(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.format(fmt);
    }

    /**
     * 添加时间
     *
     * @param date      原始日期
     * @param interval  增加的间隔
     * @param unit      单位长度
     * @return java.time.LocalDateTime
     * @author LiFaXin
     * @date 2020/9/22 11:47
     */
    public static LocalDateTime plusDateTime(LocalDateTime date, int interval, TemporalUnit unit) {
        return date.plus(interval, unit);
    }

    /**
     * 日期比较
     * 如果 localDateTime1 为空，则返回true
     * 如果 localDateTime2 为空，则返回false
     * localDateTime1 在 localDateTime2 之前返回false， 反之为true
     *
     * @param localDateTime1
     * @param localDateTime2
     * @return boolean
     * @author LiFaXin
     * @date 2020/9/22 11:49
     */
    public static boolean compareDateTime(LocalDateTime localDateTime1, LocalDateTime localDateTime2){
        // 如果 localDateTime1 为空，则返回true
        if (localDateTime1 == null) {
            return true;
        }
        // 如果 localDateTime2 为空，则返回false
        if (localDateTime2 == null) {
            return false;
        }
        // 时间比较
        return localDateTime1.compareTo(localDateTime2) < 0 ? true : false;
    }

}
