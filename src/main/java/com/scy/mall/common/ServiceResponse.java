package com.scy.mall.common;

import java.io.Serializable;

/**
 * Created by Shichengyao on 2017/7/31.
 */
public class ServiceResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public ServiceResponse(int status) {
        this.status = status;
    }

    public ServiceResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServiceResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ServiceResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public boolean isSuccess() {
        return this.status==ResponseCode.SUCCESS.getCode();
  2  }
}
