package com.dql.learn.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/10
 */
@Service("myTestService")
@Lazy
public class MyTestServiceImpl implements MyTestService {
    @Override
    public void f() {
        System.out.println("MyTestServiceImpl");
    }
}
