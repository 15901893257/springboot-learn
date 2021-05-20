package com.dql.learn.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;


import lombok.AllArgsConstructor;
import lombok.Data;

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

    @Test
    public void test02() {
        List<Man> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = "deng" + i;
            for (int j = 10; j <= 20; j++) {
                list.add(new Man(name, j));
            }
        }
        Collections.sort(list);
        Map<String, List<Man>> map = list.stream().collect(Collectors.groupingBy(Man :: getName));
//        Collections.sort(list, (o1, o2) -> o2.getAge() - o1.getAge());
        map.forEach((k1, v1) -> {
            System.out.println(k1 + ":");
            System.out.println(v1);
        });
    }

    @Test
    public void test03() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> list1 = Lists.newArrayList(6, 7, 8);
        List<Integer> list2 = Lists.newArrayList(list);
        list2.addAll(list1);
        System.out.println(list);
    }

    @Test
    public void test04() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list1 = Lists.newArrayList(6, 7, 8);
        List<Integer> list2 = Lists.newArrayList(list);
        list2.addAll(list1);
        List<Integer> list3 = list;
        list3.add(12);
//        list = list.stream().filter(i -> i % 2 > 0).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list3);
    }

}

@Data
@AllArgsConstructor
class Man implements Comparable<Man> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Man o) {
        return o.getAge().compareTo(this.getAge());
    }
}
