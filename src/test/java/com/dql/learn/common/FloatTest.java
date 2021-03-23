package com.dql.learn.common;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author dengquanliang
 * Created on 2021/3/11
 */
public class FloatTest {

    @Test
    public void test01() {
        float a = 0.1f;
        double b = 0.1;
        System.out.println(a == b);
    }

    @Test
    public void test02() {
        double a = 0.1;
        float b = 0.1f;
        BigDecimal s1 = new BigDecimal(a);
        BigDecimal s2 = new BigDecimal(0.1);
        BigDecimal s3 = new BigDecimal(Double.toString(a));
        BigDecimal s4 = new BigDecimal(String.valueOf(a));
        BigDecimal s5 = new BigDecimal(String.valueOf(b));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
