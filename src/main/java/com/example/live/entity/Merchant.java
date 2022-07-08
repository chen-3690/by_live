package com.example.live.entity;

import lombok.Data;

/**
 * 商户（通过推广链接进行注册登录）
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Merchant {
    private int id;
    // 手机号
    private String mobile;
    // 商户端登录密码
    private String pwd;
    // 店铺id，只能绑定一个
    private String shopId;
    // 店铺名称
    private String shop;
    // 商品链接
    private String goods;
    // 业务员
    private Integer opeUser;
    // 创建时间
    private String ct;
    // 登录时间
    private String lt;
}
