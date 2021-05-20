package com.dql.learn.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/4/22
 */
@Getter
@AllArgsConstructor
public enum TypeEnum {
    MAN(1, "男"),
    WOMAN(2, "女"),
    ;

    private int code;
    private String name;

    public static String getName(int code) {
        for (TypeEnum typeEnum : values()) {
            if (typeEnum.code == code) {
                return typeEnum.getName();
            }
        }
        return StringUtils.EMPTY;
    }

}
