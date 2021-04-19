package com.dql.learn.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author dengquanliang
 * Created on 2021/4/12
 */
public class ListTest {
    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.subList(0, 10);
        System.out.println(list1);
    }
}
