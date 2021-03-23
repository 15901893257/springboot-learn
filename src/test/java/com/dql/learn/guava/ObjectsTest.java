package com.dql.learn.guava;

import org.junit.Test;

import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2021/2/2
 */
public class ObjectsTest {

    @Test
    public void testEquals() {
        String a = "a";
        String b = "b";
        System.out.println(Objects.equal(a, b));
        System.out.println(Objects.equal(null, a));
        System.out.println(Objects.equal(a, null));

        System.out.println(Objects.equal(new A("a", 12), new A("a", 12)));
    }

    @Test
    public void test() {
        Double d = 2d;
        System.out.println(d == 2);
    }

    @Data
    @AllArgsConstructor
    private static class A {
        String name;
        int age;
    }

}
