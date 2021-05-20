package com.dql.learn.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/5/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanModel {
    private Integer age;

    private String name;

    private List<String> userNames;
}
