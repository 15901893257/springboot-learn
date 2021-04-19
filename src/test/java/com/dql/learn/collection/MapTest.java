package com.dql.learn.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2021/4/9
 */
public class MapTest {
    @Test
    public void test01 () {
        User user = new User("dql", 23);
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(23, user);
        user.setName("hello");
        System.out.print(userMap.get(23));
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
}
