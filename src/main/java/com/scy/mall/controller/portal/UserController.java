package com.scy.mall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Shichengyao on 2017/7/31.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @RequestMapping("login.do")
    @ResponseBody
    public Object login(String username, String password, HttpSession session) {
        return null;
    }
}
