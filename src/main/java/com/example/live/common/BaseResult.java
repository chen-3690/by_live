package com.example.live.common;

import lombok.Data;
import java.io.Serializable;

/**
 * 通用的结果返回类
 * 默认status=200
 * 成功返回code=0
 * 根据返回结果不同，返回不同的code
 *
 * @param <T>
 */
@Data
public class BaseResult<T> implements Serializable {

    private String msg;
    private int code;
    private int pages;
    private T data;

    public BaseResult(int code, String msg, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    // success
    public BaseResult(T data) {
        this.data = data;
        this.code = 200;
        this.msg = "success";
    }
    // success pages
    public BaseResult(int pages, T data) {
        this.data = data;
        this.code = 200;
        this.pages = pages;
        this.msg = "success";
    }
    public BaseResult() {
        super();
        this.code = 200;
        this.msg = "success";
    }

}