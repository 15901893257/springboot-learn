package com.dql.learn.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2020/12/11
 */
public class ImmutableListTest {

    @Test
    public void testSublist() {
        List<String> list = Lists.newArrayList("0", "1", "2", "3");
        List<String> subList = list.subList(1, 3);
        System.out.println(subList);
        //修改subList也会修改list
        subList.add(0, "5");   //list.add会抛java.util.ConcurrentModificationException异常
        System.out.println(subList);
        System.out.println(list);
    }

    @Test
    public void test01() {
        List<String> list = Lists.newArrayList("0", "1", "2", "3");
        //immutableList属于不可变集合
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        List<String> copyList = new ArrayList<>(list);
        list.add("4");
        System.out.println(immutableList);
        System.out.println(copyList);
    }

    @Test
    public void test02() {
        A a = new A("a");
        A b = new A("b");
        List<A> list = Lists.newArrayList(a, b);
        ImmutableList<A> immutableList = ImmutableList.of(a, b);
        List<A> list1 = new ArrayList<>();
        list1.add(a);
        list1.add(b);

        System.out.println("list: " + list);
        System.out.println("immutableList: " + immutableList);
        System.out.println("list1: " + list1);

        a.setName("c");
        System.out.println("list: " + list);
        System.out.println("immutableList: " + immutableList);
        System.out.println("list1: " + list1);
    }

    @Test
    public void test03() {
        int a = 32;
        int b = 12;
        ImmutableList<Integer> immutableList = ImmutableList.of(a, b);
        List<Integer> list = Lists.newArrayList(a, b);
        System.out.println("before change.........");
        immutableList.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println();
        list.forEach(e -> {
            System.out.print(e + " ");
        });
        a = 24;
        System.out.println("\nafter change.........");
        immutableList.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println();
        list.forEach(e -> {
            System.out.print(e + " ");
        });
    }

    @Data
    @AllArgsConstructor
    public static class A{
        String name;
    }

}
