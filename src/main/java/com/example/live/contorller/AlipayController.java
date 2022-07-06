package com.example.live.contorller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.example.live.common.AlipayConfig;
import com.example.live.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;


/**
 * 版本购买
 */
@Slf4j
@RestController
@RequestMapping("/pay")
public class AlipayController {


    @RequestMapping("/ali")
    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Integer months) throws IOException {

        Integer userId = UserUtil.getUserId();
        if (userId ==null) {
            httpResponse.setContentType("text/html;charset=" + AlipayConfig.charset);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", -1001);
            jsonObject.put("msg", "用户登录状态不可用!");
            httpResponse.getWriter().write(jsonObject.toJSONString());
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
            return;
        }

        //获得初始化的AlipayClient 向支付宝发送支付请求
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, AlipayConstants.FORMAT_JSON, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        // 请求
        String form = "";
        String body = null;
        String subject = null;
        String totalAmount = "1";
        String outTradeNo = "";
        String platform = "";
        String sessionId = httpRequest.getSession().getId();
        try {
            // 网页端
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
            // 同步通知url: 前端路径
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            // 异步通知url: 后台服务接口路径
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
            // 填充业务参数
            alipayRequest.setBizContent(bizContentBuild(outTradeNo, totalAmount, subject, body+"-"+months+"个月",
                    sessionId, platform, months));
            // 调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.charset);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 异步调用接口
     */
    @RequestMapping("/notify")
    public void notifyPay(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        Map<String, String> paramsMap = new HashMap<String, String>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            paramsMap.put(name, request.getParameter(name));
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
        }

        PrintWriter out = response.getWriter();
        boolean signVerified = AlipaySignature.rsaCheckV1(paramsMap, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); // 调用SDK验证签名

        String sessionId = request.getSession().getId();
        String trade_no = request.getParameter("trade_no"); // 支付宝交易号
        String order_no = request.getParameter("out_trade_no"); // 获取订单号
        String total_fee = request.getParameter("total_amount"); // 用户支付金额
        String buyer_email = request.getParameter("buyer_email"); // 买家支付宝账号
        String buyerLogonId =request.getParameter("buyer_logon_id");//买家支付宝账号
        String trade_status = request.getParameter("trade_status"); // 交易状态
        String passback_params = request.getParameter("passback_params"); // 交易状态


        if (signVerified) {
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {

                System.out.println("trade_no:"+trade_no);

            }
            out.println("success");
        } else {
            out.println("fail");
        }
    }

    private String bizContentBuild(String outTradeNo, String totalAmount, String subject, String body, String sessionId,
                                   String platform, Integer months) {
        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append("\"out_trade_no\"");
        str.append(":\"");
        str.append(outTradeNo);
        str.append("\",");
        str.append("\"product_code\":\"");
        if ("m".equals(platform)) {
            str.append("QUICK_WAP_PAY");
        } else if ("mobile".equals(platform)) {
            str.append("QUICK_MSECURITY_PAY");
        } else {
            str.append("FAST_INSTANT_TRADE_PAY");
        }
        str.append("\",");
        str.append("\"total_amount\"");
        str.append(":");
        str.append(totalAmount);
        str.append(",");
        str.append("\"subject\" : \"");
        str.append(subject);
        str.append("\",");
        str.append("\"body\" : \"");
        str.append(body);
        str.append("\",");
        str.append("\"timeout_express\" : \"");
        str.append("15m");
        str.append("\",");
        str.append("\"months\" : \"");
        str.append(months);
        str.append("\",");
        str.append("\"passback_params\" :");
        str.append("\"session_id%3d");
        str.append(sessionId);
        str.append("\" }");
        return str.toString();
    }

}
