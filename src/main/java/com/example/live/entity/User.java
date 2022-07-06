package com.example.live.entity;

import lombok.Data;

/**
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
    private String ts;

}
