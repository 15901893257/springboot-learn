package com.dql.learn.common;

import java.text.ParseException;

import org.junit.Test;

import com.dql.learn.util.DateUtil;

/**
 * @author dengquanliang
 * Created on 2021/3/17
 */
public class DateUtilTest {
    @Test
    public void test01() throws ParseException {
        String date = "20213/21";
        String date1 = "2021-1-222";
        System.out.println(DateUtil.stringToDay(date));
        System.out.println(DateUtil.stringToDate(date1, true));
    }
}
