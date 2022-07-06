package com.example.live.entity;

import lombok.Data;

/**
 * 发票
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Invoice {
    private int id;
    private String mobile;
    private String shop;
    private Integer opeUser;
    // 发票金额
    private Double money;
    // 状态：未开、已开、驳回
    private String status;
    private String remark;
    // 申请时间
    private String applyTs;
}
