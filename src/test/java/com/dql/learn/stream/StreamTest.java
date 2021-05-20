package com.dql.learn.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2021/1/10
 */
public class StreamTest {
    @Data
    public static class User {
        private int age;
        private Long time;
        private String name;
    }

    @Test
    public void test() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("mai" + i);
            user.setTime(Long.valueOf(i));
            user.setAge(i);
            users.add(user);
        }
        List<User> userList = users.stream()
                .sorted((o1, o2) -> o1.getTime() - o2.getTime() > 0 ? -1 : 1)
                .collect(Collectors.toList());
        userList.forEach(System.out::println);
    }

    @Test
    public void test01() {
        List<User> users = new ArrayList<>();
        for (int i = 2; i >= 0; i--) {
            User user = new User();
            user.setName("mai" + i);
            user.setTime(Long.valueOf(i));
            user.setAge(i);
            users.add(user);
        }
        User user = new User();
        user.setName("mai" + 4);
        user.setTime(Long.valueOf(4));
        user.setAge(4);
        users.add(user);
        Collections.sort(users, (o1, o2) -> -1);
        users.forEach(System.out::println);
    }

    @Test
    public void test02() {
        List<User> users = getUserList();
        Map<Integer, Long> map = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        map.forEach((k,v) -> {
            System.out.println(k + ": " + v);
        });

    }

    private List<User> getUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            User user = new User();
            user.setName("mai" + i);
            user.setTime(Long.valueOf(i));
            user.setAge(i);
            users.add(user);
        }

        for (int i = 10; i <= 20; i++) {
            User user = new User();
            user.setName("mai" + i);
            user.setTime(Long.valueOf(i));
            user.setAge(i);
            users.add(user);
        }

        return users;

    }


}
