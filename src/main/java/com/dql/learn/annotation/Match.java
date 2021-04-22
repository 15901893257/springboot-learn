package com.dql.learn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.dql.learn.enums.SqlMatchTypeEnum;

/**
 * @author dengquanliang
 * Created on 2021/4/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Match {
    SqlMatchTypeEnum type() default SqlMatchTypeEnum.EQ;
    String name() default "";
}
