package com.scy.mall.common;

public class Const {
    public static final String CURRENT_USER = "current_user";
    public static final String USERNAME = "username";
    public static final String EMAIL = "enail";
    public interface Role{
        int ROLE_CUSTOMER=0;  //普通用户
        int ROLE_ADMIN = 1;   //管理员用户
    }
}
