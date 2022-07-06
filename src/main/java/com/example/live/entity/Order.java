package com.example.live.entity;

import lombok.Data;

/**
 * 订单
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Order {
    private int id;
    // 订单号
    private String orderNo;
    // 交易号
    private String tradeNo;
    private String mobile;
    private String shop;
    // 权益类型：月卡、季卡、年卡
    private String buyType;
    // 金额
    private Double money;
    // 业务员
    private Integer opeUser;
    // 支付类型：支付宝
    private String payType;
    // 支付下单时间
    private String ct;
    // 支付成功时间
    private String ut;
}
