package com.example.live.entity;

import lombok.Data;

/**
 * 资源
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Data
public class Resource {
    private int id;
    private String shop;
    private String mobile;
    // 意向：跟进中、月会员、年会员、已拒绝
    private String intention;
    private String remark;

    // 创建时间
    private String ct;
    // 更新时间
    private String ut;
}
