package com.dql.learn.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.dql.learn.util.GsonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author dengquanliang
 * Created on 2020/12/11
 */
public class GsonTest {

    @Test
    public void testJsonObject01() {

    }

    @Test
    public void testToJson() {
        User user = User.builder().name("MAI").build();
        String userJson = GsonUtil.toJson(user);
        System.out.println("userJson: " + userJson);
        User user1 = GsonUtil.fromJson(userJson, User.class);
        System.out.println("user1: " + user1);
        JsonObject jsonObject = GsonUtil.fromJson(userJson, JsonObject.class);
        System.out.println("jsonObject: " + jsonObject);
        String name = jsonObject.get("name").getAsString();
        String email = jsonObject.get("email") != null ? jsonObject.get("email").getAsString() : "EMAIL";
        int age = jsonObject.get("age") != null ? jsonObject.get("age").getAsInt() : 0;
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
    }

    @Test
    public void testJsonObject() {
        JsonObject jsonObject = new JsonObject();
        for (int i = 0; i < 20; i++) {
            String key = "col" + i;
            String val = "value" + i;
            jsonObject.addProperty(key, val);
        }
        jsonObject.addProperty("col3", "val");
        Set<Map.Entry<String, JsonElement>> set = jsonObject.entrySet();
        for (Map.Entry entry : set) {

        }
    }

    @Test
    public void testFromJson() {
        List<String> list = Lists.newArrayList("1", "2", "3");
        String listJson = GsonUtil.toJson(list);
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "mai");
        map.put("age", "13");
        String mapJson = GsonUtil.toJson(map);
        List<String> jsonList = GsonUtil.fromJson(listJson, new TypeToken<List<String>>() {}.getType());
        Map<String, String> jsonMap = GsonUtil.fromJson(mapJson, new TypeToken<Map<String, String>>() {}.getType());
        System.out.println("listJson: " + listJson);
        System.out.println("jsonList: " + jsonList);
        System.out.println("mapJson: " + mapJson);
        System.out.println("jsonMap: " + jsonMap);
    }

    @Test
    public void testJson() {
        String json = "{\"工号\":\"1001\",\"员工状态\":\"1\",\"列4\":\"列4\",\"列5\":\"列5\",\"列6\":\"列6\",\"列7\":\"列7\",\"列8\":\"列8\",\"列9\":\"列9\"}";
        String json1 = "{\n" +
                "    \"工号\":1001,\n" +
                "    \"员工状态\":1,\n" +
                "    \"姓名\":2,\n" +
                "    \"列一\":\"列一\"\n" +
                "}";
        JsonObject jsonObject = GsonUtil.fromJson(json, JsonObject.class);
//        System.out.println(jsonObject.get("工号").getAsInt());
        System.out.println(jsonObject);
        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
//        for (Map.Entry entry : entries) {
//            System.out.println(entry.getValue().toString());
//        }
        JsonObject jsonObject1 = new JsonObject();
        entries.stream().forEach(entry -> {
            jsonObject1.addProperty(entry.getKey(), entry.getValue().getAsString());
        });
        System.out.println(jsonObject1);

    }

    @Test
    public void testJson01() {
        String name = "deng";
        String sex = "12";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("sex", sex);
        System.out.println(jsonObject);
        System.out.println(GsonUtil.toJson(jsonObject));
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class User{
       private String name;
       private int age;
       private String extra;
    }

    @Test
    public void testToMap() {
        String json = "{\"工号\":\"1001\",\"员工状态\":\"1\",\"列4\":\"列4\",\"列5\":\"列5\",\"列6\":\"列6\",\"列7\":\"列7\",\"列8\":\"列8\",\"列9\":\"列9\"}";
        HashMap<String, String> map = GsonUtil.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }

    @Test
    public void test() {
        String json = "";
        User user = GsonUtil.fromJson(json, User.class);
        System.out.println(user);
//        System.out.println(user.getAge());
//        System.out.println(user.getName());
    }
}
