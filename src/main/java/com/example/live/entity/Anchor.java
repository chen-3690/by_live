package com.example.live.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 主播
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/8 22:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Anchor extends BaseRowModel {
    @ExcelProperty(value = "序号",index = 0)
    private int id;
    // 昵称
    @ExcelProperty(value = "昵称",index = 1)
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
