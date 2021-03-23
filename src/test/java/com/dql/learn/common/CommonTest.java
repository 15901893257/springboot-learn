package com.dql.learn.common;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author dengquanliang
 * Created on 2020/12/15
 */
public class CommonTest {

    @Test
    public void test() {
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);
        f(a1, a2);
    }

    private void f(int a1, int a2){
        System.out.println(a1 + ":" + a2);
    }
}
