package com.scy.mall.service;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.User;

/**
 * Created by Shichengyao on 2017/7/31.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user)
}
