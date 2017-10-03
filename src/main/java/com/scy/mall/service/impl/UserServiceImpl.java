package com.scy.mall.service.impl;

import com.scy.mall.common.Const;
import com.scy.mall.common.ServerResponse;
import com.scy.mall.dao.UserMapper;
import com.scy.mall.pojo.User;
import com.scy.mall.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shichengyao on 2017/9/23.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(String username, String password) {
        int count = userMapper.checkUserName(username);
        if (count != 1) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo 密码登录MD5F
        User user = userMapper.selectLogin(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    public ServerResponse<String> register(User user) {
        int count = userMapper.checkUserName(user.getUsername());
        if (count > 0) {
            return ServerResponse.createByErrorMessage("用户名已存在");
        }
        count = userMapper.checkEmail(user.getEmail());
        if (count > 0) {
            return ServerResponse.createByErrorMessage("邮箱已注册");
        }
        user.setRole(Const.Role.ROLE_CUSTOMER);
    }
}
