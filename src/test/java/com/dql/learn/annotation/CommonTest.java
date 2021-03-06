package com.dql.learn.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.dql.learn.param.QueryParam;
import com.google.common.collect.Lists;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dengquanliang
 * Created on 2021/4/22
 */
@Slf4j
public class CommonTest {
    private static final QueryParam param = QueryParam.builder()
            .id(null)
            .name("mai")
            .year(2021)
            .accountIds(Lists.newArrayList(1L, 2L, 3L, 4L))
            .accountNames(Lists.newArrayList("李白", "王刚", "科比"))
            .build();

    @Test
    public void test01() {

//        System.out.println("param: " + param);

        Field[] fields = QueryParam.class.getDeclaredFields();
        System.out.println("fields: " + fields);
        for (Field field : fields) {
            field.setAccessible(true);

            Match match = field.getAnnotation(Match.class);
            if (match != null) {
//                System.out.println("match: " + match);
                System.out.println(field.getName() + ": " + match.type().getName());
            }
        }
    }

    @Test
    public void test02() throws IllegalAccessException {
        buildSql(param);
    }

    public <T> String buildSql(T param) throws IllegalAccessException {
        for (Field field : param.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Type type = field.getType();
            if (Objects.nonNull(field.get(param))) {
                System.out.println(type + ": " + field.get(param));
            }
            if (List.class.equals(type)) {
                List list = (List) field.get(param);
                System.out.println("list: " + list);
            }

        }
        return "";
    }

    @Test
    public void test03() throws IllegalAccessException {
        Man man = new Man();
        man.setId(123L);
        man.setIds(Lists.newArrayList(1L, 3L));
        man.setNames(Lists.newArrayList("mai", "deng", "lee"));
        for (Field field : man.getClass().getDeclaredFields()) {
            field.setAccessible(true);
//            System.out.println(field.getName());
            if (Long.class == field.getType()) {
                System.out.println(field.getName() + ": " + field.get(man));
            }
            if (List.class == field.getType()) {
                System.out.println(field.getName() + ": " + field.get(man));
            }
        }
    }

    @Test
    public void test04() {
        String s = "adOrderPlanIds";

        System.out.println(toColumn(s));
    }

    /**
     * 驼峰转下划线命名
     * @param field
     * @return
     */
    public static String toColumn(String field) {
        if (StringUtils.isBlank(field)) {
            return "";
        }
        String s = field.replaceAll("[A-Z]", "_$0").toLowerCase();
        return s.substring(0, s.length() - 1);
    }
}

@Data
class Man {
    private List<Long> ids;
    private Long id;
    private List<String> names;
}
