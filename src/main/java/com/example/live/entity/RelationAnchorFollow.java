package com.example.live.entity;

import lombok.Data;

/**
 * 商户主播跟进记录
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/8 22:30
 */
@Data
public class RelationAnchorFollow {
    private int id;
    private int maId;
    private String note;
    private String ts;
}
