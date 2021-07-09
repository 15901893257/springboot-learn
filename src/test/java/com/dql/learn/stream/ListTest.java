package com.dql.learn.stream;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.google.common.base.Splitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengquanliang
 * Created on 2021/3/18
 */
public class ListTest {
    @Test
    public void testRetain() {
        List<Long> list1 = Lists.newArrayList(1L, 2L, 3L, 4L);
        List<Long> list2 = Lists.newArrayList(1L, 4L, 5L);
        List<Long> list3 = (List<Long>) CollectionUtils.intersection(list1, list2);
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list3);
    }

    @Test
    public void test01() {
        Man man = new Man();
//        man.setList(Collections.emptyList());
        man.setList(Collections.EMPTY_LIST);
    }

    @Test
    public void test02() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list1);
    }

    @Test
    public void test03() {
        List<String> list = Lists.newArrayList("mai, mai1, mai2", "mai2,deng,lee", "1,2,3");
        List<String> list1 = list.stream().map(word -> word.split(","))
                .flatMap(Arrays:: stream)
                .distinct()
                .collect(Collectors.toList());
        List<String> list2 = list.stream().map(word -> splitWord(word))
                .flatMap(Collection:: stream)
                .distinct()
                .collect(Collectors.toList());
        list2.forEach(System.out :: println);
    }

    @Test
    public void test04() {
        Iterable<String> iterable = Splitter.on(",").trimResults().omitEmptyStrings().split("");
        List<String> list = Lists.newArrayList(iterable);
        System.out.println(list);
        list.forEach(System.out :: println);
//        iterable.forEach(System.out :: println);
    }


    @Test
    public void test06() {
        Cat cat = new Cat("cat", 1, 20L);
        Dog dog = new Dog();
        BeanUtils.copyProperties(cat, dog);
        System.out.println(dog);
        Cat cat1 = new Cat();
        BeanUtils.copyProperties(dog, cat1);
        System.out.println(cat1);
    }

    @Test
    public void test07() {
        List<String> list = new ArrayList<>();
        buildList(list);
        System.out.println(list);
    }

    @Test
    public void test09() {
        String word = "hello, hello , mai ,123";
        splitWord1(word).forEach(e -> {
            System.out.println(e + ": " + e.length());
        });
    }

    private List<String> splitWord(String word) {
        Iterable<String> iterable = Splitter.on(",").trimResults().split(word);
        return Lists.newArrayList(iterable);
    }

    private List<String> splitWord1(String word) {
        Iterable<String> iterable = Splitter.on(",").split(word);
        return Lists.newArrayList(iterable);
    }

    private void buildList(List<String> list) {
        list = Lists.newArrayList("1", "2");
    }

    @Test
    public void test08() {
        List<Dog> dogs = new ArrayList<>();
        List<Cat> cats = dogs.stream().map(source -> {
            return new Cat();
        }).collect(Collectors.toList());
        System.out.println(cats);
    }

    @Test
    public void test() {
        Dog dog = new Dog("mai", 12, 30L, new ArrayList<>());
        Cat cat = new Cat();
        BeanUtils.copyProperties(dog, cat);
        System.out.println(dog);
        System.out.println(cat);
    }

}

@Data
class Man {
    private List<Man> list;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Dog {
    private String name;
    private int age;
    private long price;
    private List<Dog> dogs;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Cat {
    private String name;
    private Integer age;
    private Long price;
}

