package com.dql.learn.annotation;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.dql.learn.entity.ViewModel;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/5/21
 */
public class AnnotationTest {
    @Test
    public void test01() {
        for (Field field : ViewModel.class.getDeclaredFields()) {
            field.setAccessible(true);
            ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
            System.out.println(field.getName() + ": " + apiModelProperty.value());
        }
    }

    @Test
    public void test02() {
        System.out.println(StringUtils.isNumeric("123"));
        System.out.println(StringUtils.isNumeric(" 123"));
        System.out.println(StringUtils.isNumeric("123 "));
        System.out.println(StringUtils.isNumeric("1 23"));
        System.out.println(StringUtils.isNumeric("h123"));
        System.out.println(StringUtils.isNumericSpace(" 123"));
        System.out.println(StringUtils.isNumericSpace("12 3"));
        System.out.println(StringUtils.isNumericSpace(" 123 "));
    }
}
