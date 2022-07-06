package com.example.live.entity;

import lombok.Data;

/**
 * 商户
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class merchant {
    private int id;
    // 手机号
    private String mobile;
    // 昵称
    private String nickname;
    // 店铺名称
    private String shop;
    // 业务员
    private Integer opeUser;
    // 余额
    private Double money;
    // 任务发布数
    private int task;

    // 创建时间
    private String ct;
    // 更新时间
    private String ut;
}
