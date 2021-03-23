package com.dql.learn.common;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dengquanliang
 * Created on 2021/1/7
 */
public class LombokTest {

    @Test
    public void test() {
        Cat cat = Cat.builder().name("deng").build();
        Dog dog = Dog.builder().name("mai").build();
        Dog dog1 = new Dog();
        System.out.println(cat);
        System.out.println(dog);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dog {
        private String name;
        private Integer age;
        private String remark;
    }

    @Builder
    @Getter
    @Setter
    @ToString
    public static class Cat {
        private String name;
        private int age;
        private String remark;
    }

}
