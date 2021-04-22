package com.dql.learn.enums;

/**
 * @author dengquanliang
 * Created on 2021/4/22
 */
public enum SqlMatchTypeEnum {
    EQ("="),
    GT(">"),
    GE(">="),
    LT("<"),
    LE("<="),
    IN("in"),
    LIKE("like");

    private String name;

    private SqlMatchTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
