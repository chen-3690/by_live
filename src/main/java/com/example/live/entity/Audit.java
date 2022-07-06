package com.example.live.entity;

import lombok.Data;

/**
 * 合同审核
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Audit {
    private int id;
    private String mobile;
    private String shop;
    private Integer opeUser;
    private String status;
    // 商家介绍
    private String introduce;
    // 审核类型
    private String type;
    // 申请时间
    private String applyTs;
    // 权益类型：月卡、季卡、年卡
    private String buyType;
    // 合同
    private String contract;
    // 操作时间
    private String opeTs;
    // 驳回原因
    private String remark;

}
