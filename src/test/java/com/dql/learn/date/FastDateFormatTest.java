package com.dql.learn.date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import com.google.common.base.Strings;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/4/25
 */
public class FastDateFormatTest {
    private static final FastDateFormat SIMPLE_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");

    @Test
    public void test01() {
        String time = SIMPLE_DATE_FORMAT.format(System.currentTimeMillis());
        System.out.println(time);
        String t1 = time.replaceAll("-", "");
        String t2 = time.replace("-", "");
        System.out.println(t1);
        System.out.println(t2);
    }

    @Test
    public void test02() {
        String pDate = "20200401";
        String sql = String.format("select * from s where p_date = %s", pDate);
        System.out.println(sql);
    }

    @Test
    public void test03() {
        String s = null;
        System.out.println(s.getClass());
    }


}
