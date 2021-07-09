package com.dql.learn.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/17
 */
public class JoinerTest {

    @Test
    public void test01() {
        StringJoiner stringJoiner = new StringJoiner(",");
        List<String> list = getList();
        list.forEach(e -> stringJoiner.add(e));
        System.out.println(stringJoiner.toString());
        String s = Joiner.on(",").join(list);
    }

    @Test
    public void test02() {
        long a = 1234L;
        long b = 11L;
        System.out.println(a * 1.0 / b);
    }

    @Test
    public void test03() {
        String s = "SELECT sum(total_cost) cost, #field# group by #field#";
        System.out.println(s.replace("#field#", "name"));
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }
        return list;
    }
}
