package com.example.live.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.live.common.BaseResult;
import com.example.live.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/6
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Override
    public BaseResult<?> userLogin(HttpSession session, JSONObject jo) {
        String mobile = jo.getString("mobile");
        String code = jo.getString("code");
        String pwd = jo.getString("pwd");
        return null;
    }
}
