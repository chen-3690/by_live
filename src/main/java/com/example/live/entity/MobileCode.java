package com.example.live.entity;

import lombok.Data;

/**
 * 手机验证码
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/10 13:37
 */
@Data
public class MobileCode {
    private int id;
    private String mobile;
    private String code;
    private String ts;
}
