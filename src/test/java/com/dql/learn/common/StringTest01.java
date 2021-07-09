package com.dql.learn.common;


import org.junit.Test;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/5/8
 */
public class StringTest01 {

    @Test
    public void test01() {
        String name = "/tmp/hello_%s.xlsx";
        String fileName = String.format(name, System.currentTimeMillis());
        System.out.println(fileName);
    }

    @Test
    public void test02() {
        String msg = "一共%s个冲突";
        Long num = 30L;
        String s = String.format(msg, num);
        System.out.println(s);
    }

    @Test
    public void test03() {
        String time = "startTime";
        System.out.println(time.endsWith("Time"));
    }


}
