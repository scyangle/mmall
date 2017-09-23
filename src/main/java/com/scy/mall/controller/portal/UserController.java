package com.scy.mall.controller.portal;

import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.User;
import com.scy.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Shichengyao on 2017/7/31.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("login.do")
    @ResponseBody
    public Object login(@RequestParam(required = true) String username, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(username, password);
        return response;
    }
}
