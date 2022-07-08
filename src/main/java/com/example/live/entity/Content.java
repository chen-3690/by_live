package com.example.live.entity;

import lombok.Data;

/**
 * 备注
 * （某条数据多个备注
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/8 21:40
 */
@Data
public class Content {
    private int id;
    // 主对象id
    private int oid;
    private String note;
    private String ts;
}
