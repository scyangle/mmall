package com.scy.mall.service.impl;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.dao.UserMapper;
import com.scy.mall.pojo.User;
import com.scy.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shichengyao on 2017/9/23.
 */
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        int count = userMapper.checkUserName(username);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        return null;
    }
}
