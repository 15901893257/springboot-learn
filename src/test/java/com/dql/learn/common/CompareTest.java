package com.dql.learn.common;

import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengquanliang
 * Created on 2021/2/4
 */
public class CompareTest {

    @Test
    public void test01() {
        Man man1 = Man.builder().name("mai1").age(1).count(20).build();
        Man man2 = Man.builder().name("mai2").age(4).count(12).build();
        List<Man> list = Lists.newArrayList(man1, man2);
        list.forEach(System.out :: println);
        Collections.sort(list);
        list.forEach(System.out :: println);
    }

    @Test
    public void test02() {
        Dog dog = new Dog();
        dog.setName("dog");
        dog.setAge(13);
        f(dog);
    }

    private void f(Animal animal) {
        System.out.println(animal.getName());

        Dog dog = (Dog) animal;
        System.out.println(dog);
        System.out.println(dog.getName());
    }
}

@Data
@Builder
class Man implements Comparable<Man> {
    private String name;
    private int age;
    private Integer count;


    @Override
    public int compareTo(Man o) {
        return this.count.compareTo(o.count);
//        return this.age - o.age;
    }
}

@Data
class Animal {
    private String name;
}

@Data
class Dog extends Animal{
    private int age;
}

