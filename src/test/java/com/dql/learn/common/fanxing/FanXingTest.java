package com.dql.learn.common.fanxing;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author dengquanliang
 * Created on 2021/3/9
 */
public class FanXingTest {

    @Test
    public void test01() {
        ArrayList<Integer> integerList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();

        System.out.println(integerList.getClass() == stringList.getClass());   //输出为true
    }

    @Test
    public void test02() {
        Generic<Integer> integerGeneric = new Generic<>(124);
        Generic<String> stringGeneric = new Generic<>("mai");
        Generic generic = new Generic("DENG");

        System.out.println(integerGeneric.getKey());
        System.out.println(stringGeneric.getKey());
        System.out.println(generic.getKey());
        integerGeneric.showKey(123);
    }

    class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        public <T> T getNumber(T k) {
            return k;
        }

        public void showKey(T key) {
            System.out.println(key);
        }
    }
}
