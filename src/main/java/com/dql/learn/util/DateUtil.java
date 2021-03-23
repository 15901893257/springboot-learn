package com.dql.learn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dengquanliang
 * Created on 2021/3/17
 */
@Slf4j
public class DateUtil {
    private static final String DAY_FORMAT = "yyyy-MM-dd";
    private static final String DAY_FORMAT_1 = "yyyy/MM/dd";
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     *  long转换成日期格式
     */
    public static String longToDay(long second) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAY_FORMAT);
        return simpleDateFormat.format(second);
    }

    /**
     *  long转换成日期格式
     */
    public static String longToTime(long second) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        return simpleDateFormat.format(second);
    }

    /**
     *  String转换成日期格式
     */
    public static Date stringToDate(String time, boolean day) throws ParseException {
        SimpleDateFormat simpleDateFormat;
        if (day) {
            simpleDateFormat = new SimpleDateFormat(DAY_FORMAT);
        } else {
            simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        }
        Date date = simpleDateFormat.parse(time);
        return date;
    }

    public static Date stringToDay(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAY_FORMAT_1);
        Date date;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            log.info("日期格式不规范");
            throw new RuntimeException();
        }
        return date;
    }

    public static long stringToLong(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DAY_FORMAT);
        Date date = simpleDateFormat.parse(time);
        return date.getTime();
    }
}
