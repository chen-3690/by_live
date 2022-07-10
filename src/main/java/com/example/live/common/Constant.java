package com.example.live.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用参数
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/07/06
 */
public class Constant {

    // 超级管理员user_id=11
    public static final int admin_id = 11;

    public static final String session_user = "user";

    public static final String split = ",";
    // 发送邮件主题
    public static final String email_subject = "开票信息";

    // 商品链接：3545396053325007934
    public static final String goods_url = "https://haohuo.jinritemai.com/views/product/detail?id=";
    // 店铺链接：13939925088
    public static final String  shop_url = "https://haohuo.jinritemai.com/views/shop/index?id=";

    // 数据转换
    public static Map<String, String> ipMap;
    static {
        ipMap = new HashMap<>();
        // 定时任务环境  ./deploy.sh 172.17.64.60
        ipMap.put("VM-64-60-ubuntu", "60");
    }
}
