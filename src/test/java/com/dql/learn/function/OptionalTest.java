package com.dql.learn.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2020/12/8
 */
public class OptionalTest {

    @Test
    public void test01() {
        UserOPT userOPT = new UserOPT();
        List<UserOPT> list = new ArrayList<>();
        Optional<List<UserOPT>> opts = Optional.ofNullable(list);
        userOPT.setAge(12);
        userOPT.setName("mai");
        Optional<UserOPT> opt = Optional.ofNullable(userOPT);
        Optional<String> name = opt.map(UserOPT::getName);
        System.out.println(name.get());
        UserOPT userOPT1 = opt.get();
        System.out.println(opts.isPresent());
        System.out.println(userOPT == userOPT1);
        System.out.println(userOPT1);
    }
    @Data
    public static class UserOPT {
        private String name;
        private int age;
    }
}
