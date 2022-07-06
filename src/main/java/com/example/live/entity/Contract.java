package com.example.live.entity;

import lombok.Data;

/**
 * 合同审核
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Contract {
    private int id;
    private String mobile;
    private String shop;
    private Integer opeUser;
    // 权益类型：月卡、季卡、年卡
    private String buyType;
    // 合同类型：纸质、电子
    private String contractType;
    // 状态：待审核、审核通过、已拒绝、已解除
    private String status;
    // 提交时间
    private String ct;
    // 拒绝时间
    private String refuseTs;
    // 拒绝原因
    private String refuseReason;
    // 解除时间
    private String relieveTs;
    // 解除原因
    private String relieveReason;
    // 合同内容（pdf格式）
    private String content;
}
