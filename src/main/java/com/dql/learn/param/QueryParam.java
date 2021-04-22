package com.dql.learn.param;

import java.util.List;

import com.dql.learn.annotation.Match;
import com.dql.learn.enums.SqlMatchTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengquanliang
 * Created on 2021/4/22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryParam {
    @Match(type = SqlMatchTypeEnum.EQ)
    private Long id;
    @Match(type = SqlMatchTypeEnum.EQ)
    private Integer year;
    @Match(type = SqlMatchTypeEnum.EQ)
    private String name;
    @Match(type = SqlMatchTypeEnum.IN)
    private List<Long> accountIds;
    @Match(type = SqlMatchTypeEnum.IN)
    private List<String> accountNames;
}
