package com.dql.learn.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Maps;

import lombok.Builder;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2020/12/14
 */
public class MapToListTest {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(User.builder()
                    .name("mai" + i)
                    .age(i)
                    .msg("msg")
                    .build());
        }
        userList.add(User.builder().name("mai0")
                .age(13)
                .msg("msg")
                .build());
    }

    @Test
    public void testGuava() {
//        Map<String, User> userMap = Maps.uniqueIndex(userList, User::getName);
//        Map<String, User> userMap1 = userList.stream().collect(Collectors.toMap(User :: getName, Function.identity()));
        Map<String, Integer> ageMap = userList.stream()
                .collect(Collectors.toMap(User :: getName, User :: getAge, (k1, k2) -> k1));
        Map<String, Integer> ageMap1 = userList.stream()
                .collect(Collectors.toMap(User :: getName, User :: getAge, (k1, k2) -> k2));
//        Map<String, Integer> ageMap2 = userList.stream()
//                .collect(Collectors.toMap(User :: getName, User :: getAge));
        System.out.println(ageMap);
        System.out.println(ageMap1);
//        System.out.println(ageMap2);
    }
    @Data
    @Builder
    public static class User{
        private String name;
        private int age;
        private String msg;
    }
}
