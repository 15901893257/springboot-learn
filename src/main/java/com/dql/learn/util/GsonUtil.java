package com.dql.learn.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;

/**
 * @author dengquanliang
 * Created on 2020/12/11
 */
public class GsonUtil {

    private static final Gson GSON = new Gson();

    /**
     * 将Object转换成json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    /**
     * 将json字符串转换成对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    /**
     * 将json字符串转换成Collection
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }
}
