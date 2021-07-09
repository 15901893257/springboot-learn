package com.dql.learn.service;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/24
 */
public class TestServiceImpl implements MyTestService {
    @Override
    public void f() {
        System.out.println("TestServiceImpl");
    }

    @Override
    public List<String> getList() {
        return Lists.newArrayList("1", "2");
    }

    public static void main(String[] args) {
        TestServiceImpl testService = new TestServiceImpl();
        MyTestServiceImpl myTestService = new MyTestServiceImpl();
        System.out.println(testService.getList());
        System.out.println(myTestService.getList());
    }
}
