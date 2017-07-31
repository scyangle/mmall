package com.scy.mall.service;

import com.scy.mall.pojo.User;

/**
 * Created by Shichengyao on 2017/7/31.
 */
public interface IUserService {
    ServiceResponse<User> login(String username, String password);
}
