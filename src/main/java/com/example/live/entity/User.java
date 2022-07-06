package com.example.live.entity;

import lombok.Data;

/**
 * 后台用户、商户用户
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class User {
    private int id;
    private String name;
    private String mobile;
    private String pwd;
    private String remark;

    // 创建时间
    private String ct;
    // 更新时间
    private String ut;

}
