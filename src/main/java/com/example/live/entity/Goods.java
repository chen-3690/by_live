package com.example.live.entity;

import lombok.Data;

/**
 * 商品
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Goods {
    private int id;
    // 商户id
    private int merchantId;
    // 商品名称
    private String goodsName;
    // 活动类型
    private String activeType;
    // 业务员
    private Integer opeUser;
    // 奖励说明
    private String award;
    // 样品数
    private int sample;
    // 样品剩余数
    private int residue;
    // 申请时间
    private String applyTs;
    // 开始时间
    private String startTs;
    // 状态：推广中、下架、结束、已拒绝、
    private String status;
    // 对应状态时间：下架时间、结束时间
    private String statusTs;
    // 下架原因、驳回原因
    private String remark;

    // 创建时间
    private String ct;
    // 更新时间
    private String ut;
}
