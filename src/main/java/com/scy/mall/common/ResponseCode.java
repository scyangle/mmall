package com.scy.mall.common;

/**
 * Created by Shichengyao on 2017/7/31.
 */
public enum ResponseCode {
    SUCCESS(0, "SUCCESS"), ERROR(1, "ERROR"), ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"), NEED_LOGIN(10, "NEED_LOGIN");
    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
