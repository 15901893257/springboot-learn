package com.dql.learn.entity;

import com.dql.learn.annotation.ApiModelProperty;

import lombok.Data;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/5/21
 */
@Data
public class ViewModel {
    @ApiModelProperty("备案规则ID")
    private Long ruleId;
    @ApiModelProperty("备案类型")
    private String taskType;
    @ApiModelProperty("生效时间")
    private String effectTime;
    @ApiModelProperty("责任人类型")
    private String ownerType;
    @ApiModelProperty("规则类型")
    private String ruleType;
    @ApiModelProperty("营业执照名称")
    private String corpName;
    @ApiModelProperty("一级行业")
    private String firstIndustryName;
    @ApiModelProperty("二级行业")
    private String secondIndustryName;
    @ApiModelProperty("产品名")
    private String productName;
    @ApiModelProperty("广告主ID")
    private Long accountId;
    @ApiModelProperty("责任人")
    private String owner;
    @ApiModelProperty("任务备案团队")
    private String registerTeam;
    @ApiModelProperty("备案状态")
    private String effectiveStatus;
    @ApiModelProperty("失效原因")
    private String reason;
    @ApiModelProperty("冲突类型")
    private String conflict;
    @ApiModelProperty("冲突责任人")
    private String conflictUsernames;
    @ApiModelProperty("最新操作人")
    private String updateUsername;
    @ApiModelProperty("最新操作时间")
    private String updateTime;
    @ApiModelProperty("规则创建人")
    private String createUsername;
    @ApiModelProperty("创建时间")
    private String createTime;
}
