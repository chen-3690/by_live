package com.example.live.entity;

import lombok.Data;

/**
 * 合同
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Contract {
    private int id;
    // 商户店铺id
    private Integer merchantId;
    // 业务员
    private Integer opeUser;
    // 权益类型：月卡-1、季卡-2、年卡-3
    private int buyType;
    // 提交时间
    private String ct;
    // 操作时间
    private String ut;
    // 备注
    private String remark;
    // 电子合同内容
    private String content;
    // 签署状态
    private int signStatus;
    // 签署类型：1-企业签署、2-个人签署
    private int signType;
    // 店铺公司名称
    private String company;
    // 统一社会信用代码/签署人姓名
    private String tax;
    // 法定代表人/签署人身份证号
    private String owner;
    // 签署人手机号
    private String mobile;

}
