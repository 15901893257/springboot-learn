package com.dql.learn.reflect;

import java.lang.reflect.Field;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.dql.learn.entity.BeanModel;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/5/8
 */
public class ReflectTest {
    @Test
    public void test01() throws IllegalAccessException {
        BeanModel model = new BeanModel(12, "mai", Lists.newArrayList("deng", "lee", "wang"));
        BeanModel model1 = new BeanModel();
        model1.setAge(12);
        model1.setName("deng");
        f(model);
    }

    private void f(Object obj) throws IllegalAccessException {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        Class clazz = obj.getClass();
//        System.out.println(clazz);
//        System.out.println(clazz.getSuperclass());
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object val = field.get(obj);
//            String value;
//
//            if (val instanceof Collection) {
//                System.out.print("list, ");
//                value = ((Collection<Object>) val).stream().map(Object::toString).collect(Collectors.joining(","));
//            } else {
//                value = val.toString();
//            }
//            System.out.println(field.getName() + ": " + val.toString());
            System.out.println(field.getName()  + ": " + field.getType());
            if (List.class != field.getType() && String.class != field.getType()) {
                System.out.println("no");
                continue;
            }

        }
    }
}
