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
    // 商户店铺id
    private int merchantId;
    // 业务员
    private Integer opeUser;
    // 权益类型：月卡-1、季卡-2、年卡-3
    private int buyType;
    // 合同类型：纸质-0、电子-1
    private int contractType;
    // 当前状态：待审核-0、审核通过-1、审核拒绝-2、已解除-3
    private int status;
    // 提交时间
    private String ct;
    // 操作时间
    private String ut;
    // 拒绝原因、解除原因
    private String remark;
    // 合同内容（pdf格式）
    private String content;
}
