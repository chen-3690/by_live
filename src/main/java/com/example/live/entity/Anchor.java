package com.example.live.entity;

import lombok.Data;

/**
 * 主播
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/8 22:23
 */
@Data
public class Anchor {
    private int id;
    // 昵称
    private String nickname;
    // 头像
    private String img;
    // 抖音号id
    private String authorId;
    // 粉丝
    private Integer fans;
    // 推广类目
    private String category;
    // 推广商品
    private Integer goods;
    // 橱窗销量
    private Integer sales;



}
