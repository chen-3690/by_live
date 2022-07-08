package com.example.live.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 链接请求
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/8 23:43
 */
@Component
public class RestUtil {

    @Autowired
    private RestTemplate restTemplate;

    private static final RestTemplate template = getInstance();

    private static RestTemplate getInstance() {
        if (template != null) {
            return template;
        }
        RestTemplate restTemplate = new RestTemplate();
        // 单独设置超时时间
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(3000);
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(3000);
        restTemplate.getMessageConverters().add(new JacksonConverter());
        return restTemplate;
    }

    public JSONObject demo(String keyword) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36");
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
        ResponseEntity<JSONObject> entity = restTemplate.exchange("" + keyword, HttpMethod.GET, httpEntity, JSONObject.class);
        return entity.getBody();
    }

}
