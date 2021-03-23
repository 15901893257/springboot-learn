package com.dql.learn.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import com.google.common.base.Joiner;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2020/12/10
 */
public class StringTest {

    @Test
    public void testJoin() {
        List<String> list = Lists.newArrayList("1", "2", "3");
        String msg = "hello" + String.join(",", list);
        String msg1 = "hello" + String.join(",", "1", "2");
        System.out.println(msg);
        System.out.println(msg1);
    }

    @Test
    public void test01() {
        List<String> list = Lists.newArrayList("1", "2", "3");
        String msg = "hello" + StringUtils.join(list);
        System.out.println(msg);
    }

    @Test
    public void testJoiner() {
        List<String> list = Lists.newArrayList("1", "2", "3");
        String msg = "hello," + Joiner.on(",").skipNulls().join(list);
        System.out.println(msg);
    }

    @Test
    public void testIsBlank() {
        String s = "";
        String s1 = "   ";
        System.out.println(StringUtils.isBlank(s));
        System.out.println(StringUtils.isBlank(s1));

        System.out.println(StringUtils.isEmpty(s));
        System.out.println(StringUtils.isEmpty(s1));
    }

    @Test
    public void testTrim() {
        String str1 = "    hello world    ";
        String str2 = "hello world   ";
        String s1 = str1.trim();
        String s2 = str2.trim();
        System.out.println(s1.length() + ":" + s1);
        System.out.println(s2.length() + ":" + s2);
    }

    @Test
    public void testSpilt() {
        String name = "邓权亮(dengquanliang)";
        String userName = name.split("\\(")[1].split("\\)")[0];
        System.out.println(userName);
    }

    @Test
    public void testStringToLong() {
        String a = "110";
        Long a1 = Long.valueOf(a);
        String b = "1a";
        try {
            Long b1 = Long.valueOf(b);
        } catch (NumberFormatException e) {
            System.out.println("失败");
        }
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("110", "21", "ab", "2", "2q", "-1", "1.1", "0");
        List<String> list1 = Arrays.asList("110", "21", "21", "2", "22");
        List<String> errorList = new ArrayList<>();
        Set<Long> set = list.stream().map(e -> {
            Long a = null;
            try {
                a = Long.valueOf(e);
            } catch (NumberFormatException numberFormatException) {
                errorList.add(e);
            }
            return a;
        }).collect(Collectors.toSet());
        System.out.println(set);
        System.out.println(errorList);
        list.forEach(e -> {
            if (StringUtils.isNumeric(e)) {
                System.out.println(e);
            }
        });
    }

    @Test
    public void test03() {
        List<Long> list1 = Arrays.asList(1L, 2L, 3L);
        List<Long> list2 = Arrays.asList(2L, 3L, 1l);
        System.out.println(CollectionUtils.isEqualCollection(list1, list2));
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(CollectionUtils.isEqualCollection(list1, list2));
    }

    @Test
    public void test04() {
        List<User> list = new ArrayList<>();
        list.add(new User("mai", 23));
        list.add(new User("mai", 24));
        list.add(new User("mai1", 25));
        List<String> strings = list.stream().map(User::getName).distinct().collect(Collectors.toList());
        System.out.println(strings);
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
}