package com.dql.learn.service;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/10
 */
public interface MyTestService {
    void f();

    default List<String> getList() {
        return Lists.newArrayList("mai");
    }
}
