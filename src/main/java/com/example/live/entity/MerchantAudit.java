package com.example.live.entity;

import lombok.Data;

/**
 * 商家店铺审核
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class MerchantAudit {
    private int id;
    // 商家店铺id
    private int merchantId;
    // 业务员
    private Integer opeUser;
    // 状态：待审核、未开通、已拒绝、已开通/已过期/快到期/已解除
    private String status;
    // 商家介绍（<140字）
    private String introduce;
    // 审核类型：新增、修改、删除
    private String type;
    // 申请时间
    private String applyTs;
    // 权益类型：月卡-1、季卡-2、年卡-3
    private Integer buyType;
    // 合同
    private String contract;
    // 操作时间
    private String opeTs;
    // 备注：驳回原因
    private String remark;

}
