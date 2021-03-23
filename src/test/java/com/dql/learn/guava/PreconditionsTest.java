package com.dql.learn.guava;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/**
 * @author dengquanliang
 * Created on 2020/12/11
 */
public class PreconditionsTest {

    private static  Map<String, String> map = ImmutableMap.of(
            "userId", "工号",
            "name", "姓名",
            "email", "邮箱前缀"
    );

    @Test
    public void test01() {
        List<String> list = Lists.newArrayList("工号", "姓名", "邮箱前缀");
        ParamPreconditions paramPreconditions = new ParamPreconditions();
        try {
            paramPreconditions.check(map.get("userId").equals(list.get(0)), "格式错误0")
            .check(map.get("name").equals(list.get(1)), "格式错误1")
            .check(map.get("email").equals(list.get(0)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
