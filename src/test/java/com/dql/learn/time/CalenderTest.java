package com.dql.learn.time;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import com.dql.learn.util.DateUtil;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/7/1
 */
public class CalenderTest {
    private static final long YEAR_MILLI = 365 * 24 * 60 * 60 * 1000L;

    @Test
    public void test01() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMinTime(calendar);
        System.out.println(calendar.getTime());
        System.out.println(DateUtil.longToTime(calendar.getTime().getTime()));
    }

    @Test
    public void test02() {
        long time = System.currentTimeMillis();
        System.out.println(DateUtil.longToTime(time));
        System.out.println(DateUtil.longToTime(time - YEAR_MILLI));
    }

    @Test
    public void test03() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test04() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2021);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(calendar);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar1.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        calendar1.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        setMinTime(calendar1);
        System.out.println(calendar.getTime());
        System.out.println(calendar1.getTime());
    }

    @Test
    public void test05() {
        List<Integer> list = Lists.newArrayList(4, 5, 8, 2, 3, 9);
        Collections.sort(list);
        System.out.println(list);
    }

    private static void setMinTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

}
