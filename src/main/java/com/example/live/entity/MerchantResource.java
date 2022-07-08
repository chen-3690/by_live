package com.example.live.entity;

import lombok.Data;

/**
 * 商户资源
 * （绑定了店铺的商户
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class MerchantResource {
    private int id;
    // 商户店铺id
    private int merchantId;
    // 意向程度：未联系-0、跟进中-1、月会员-2、季会员-3、年会员-4、已拒绝-5
    private int intention;
    // 会员剩余天数（<7天加红）
    private int day;
    // 创建时间
    private String ct;
    // 更新时间
    private String ut;
}
