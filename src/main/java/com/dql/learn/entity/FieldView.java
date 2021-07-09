package com.dql.learn.entity;

import com.dql.learn.annotation.ApiModelProperty;

import lombok.Data;

/**
 * @author dengquanliang <dengquanliang@kuaishou.com>
 * Created on 2021/6/10
 */
@Data
public class FieldView {
    @ApiModelProperty("排期时间")
    private String pDate;
    //维度-产品
    @ApiModelProperty("产品id")
    private Long adProductId;
    @ApiModelProperty("产品名称")
    private String adProductName;
    @ApiModelProperty("产品类型")
    private String adProductType;
    @ApiModelProperty("产品开屏类型")
    private String adSplashType;
    @ApiModelProperty("广告位id")
    private Long adPositionId;
    @ApiModelProperty("广告位名称")
    private String adPositionName;
    @ApiModelProperty("广告位类型")
    private String positionType;

    //维度-账户
    @ApiModelProperty("代理商id")
    private Long agentId;
    @ApiModelProperty("代理商名称")
    private String agentName;
    @ApiModelProperty("广告主公司名")
    private String corporationName;
    @ApiModelProperty("客户简称")
    private String simpleCustomerName;
    @ApiModelProperty("投放账户id")
    private Long accountId;
    @ApiModelProperty("投放账户-昵称")
    private String accountName;

    //维度-账户责任人
    @ApiModelProperty("直客销售负责人")
    private String directCustomerSale;
    @ApiModelProperty("直客运营负责人")
    private String directCustomerOperator;
    @ApiModelProperty("渠道销售负责人")
    private String channelSale;
    @ApiModelProperty("渠道运营负责人")
    private String channelOperator;

    //维度-项目
    @ApiModelProperty("项目id")
    private Long projectId;
    @ApiModelProperty("项目名称")
    private String projectName;
    @ApiModelProperty("项目状态")
    private String projectStatus;
    @ApiModelProperty("项目直客销售负责人")
    private String projectSalesList;
    @ApiModelProperty("项目渠道销售负责人")
    private String projectChannelSalesList;
    @ApiModelProperty("项目运营负责人")
    private String projectOperatorList;
    @ApiModelProperty("项目运营协作人")
    private String projectOperatorPartnerList;
    @ApiModelProperty("品牌运营责任人")
    private String projectBrandOperatorList;
    @ApiModelProperty("品运协作人")
    private String projectBrandOperatorPartnerList;

    //维度-订单
    @ApiModelProperty("订单编号")
    private Long orderId;
    @ApiModelProperty("订单名称")
    private String orderName;
    @ApiModelProperty("订单类型")
    private String orderType;
    @ApiModelProperty("订单状态")
    private String putStatus;
    @ApiModelProperty("订单创建时间")
    private String orderCreateTime;
    @ApiModelProperty("订单修改时间")
    private String orderUpdateTime;
    @ApiModelProperty("订单创建人")
    private String operator;

    //维度-排期
    @ApiModelProperty("订单排期id")
    private Long orderPlanId;
    @ApiModelProperty("订单投放开始时间")
    private String deliverStartTime;
    @ApiModelProperty("订单投放结束时间")
    private String deliverEndTime;

    //维度-合同
    @ApiModelProperty("一级合同类型")
    private String contractTypeL1;
    @ApiModelProperty("二级合同类型")
    private String contractTypeL2;
    @ApiModelProperty("合同编号")
    private String contractId;
    @ApiModelProperty("合同名称")
    private String contractName;

    //维度-行业
    /**
     * 行业群
     */
    @ApiModelProperty("行业群")
    private String industryGroupName;
    @ApiModelProperty("一级行业")
    private String industryName;
    @ApiModelProperty("二级行业")
    private String subIndustryName;

    //维度-业务线
    @ApiModelProperty("一级业务线")
    private String businessLine;
    @ApiModelProperty("二级业务线")
    private String subBusinessLine;

    //维度-其它
    @ApiModelProperty("补量原因")
    private String replenishReason;
    @ApiModelProperty("招商类型")
    private String merchantsType;

    //指标-变现效果
    @ApiModelProperty("开屏曝光量")
    private Long adSplashImpression;
    @ApiModelProperty("开屏点击量")
    private Long adSplashClick;
    @ApiModelProperty("开屏actionbar点击量")
    private Long adSplashActionBarClick;
    @ApiModelProperty("素材曝光量")
    private Long adItemImpression;
    @ApiModelProperty("素材点击量")
    private Long adItemClick;
    @ApiModelProperty("封面曝光量")
    private Long adPhotoImpression;
    @ApiModelProperty("封面点击量")
    private Long adPhotoClick;
    @ApiModelProperty("封面actionbar点击量")
    private Long adFeedCoverActionBarClick;
    @ApiModelProperty("广告曝光量")
    private Long adShow;

    //指标-互动数据
    @ApiModelProperty("3s播放数")
    private Long adPhotoPlayed3s;
    @ApiModelProperty("5s播放数")
    private Long adPhotoPlayed5s;
    @ApiModelProperty("播放完成数")
    private Long adPhotoPlayedEnd;
    @ApiModelProperty("点赞数")
    private Long adPhotoLike;
    @ApiModelProperty("评论数")
    private Long adPhotoComment;
    @ApiModelProperty("分享数")
    private Long adPhotoShare;
    @ApiModelProperty("新增关注数")
    private Long adPhotoFollow;
    @ApiModelProperty("取消点赞数")
    private Long adPhotoCancelLike;
    @ApiModelProperty("取消关注数")
    private Long adPhotoUnfollow;
    @ApiModelProperty("拉黑数")
    private Long adPhotoBlock;
    @ApiModelProperty("举报数")
    private Long adPhotoReport;

    //指标-消耗
    @ApiModelProperty("订单总金额")
    private Long orderTotalNetPrice;
    @ApiModelProperty("排期购买数量")
    private Long purchaseAmount;
    @ApiModelProperty("折算后单价 单位:元")
    private Double price;
    @ApiModelProperty("刊例单价")
    private String rateCardPrice;
    @ApiModelProperty("折扣")
    private String discount;
    @ApiModelProperty("溢价比例")
    private String premiumRate;
    @ApiModelProperty("排期资源日净价")
    private Double totalNetPrice;
    @ApiModelProperty("计划投放量")
    private Long budget;
}
