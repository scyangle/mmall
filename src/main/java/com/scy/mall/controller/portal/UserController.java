package com.scy.mall.controller.portal;

import com.scy.mall.common.Const;
import com.scy.mall.common.ResponseCode;
import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.User;
import com.scy.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Shichengyao on 2017/7/31.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("login.do")
    @ResponseBody
    public Object login(@RequestParam(required = true) String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
    @RequestMapping("logout.do")
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess("退出登录");
    }

    @RequestMapping("register.do")
    @ResponseBody
    public ServerResponse<String> register(User user) {
       return iUserService.register(user);
    }

    @RequestMapping("check_valid.do")
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    @RequestMapping("get_user_info.do")
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (null != user) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取用户当前信息");
    }

    @RequestMapping("forget_get_question.do")
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }

    @RequestMapping("forget_check_answer.do")
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username,String question,String answer) {
        return iUserService.forgetCheckAnswer(username, question, answer);
    }

    @RequestMapping("forget_reset_password.do")
    @ResponseBody
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }

    @RequestMapping(value = "reset_password.do")
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpSession session, String passwordNew, String passwordOld) {
        User currentUser =(User)session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld, passwordNew, currentUser);
    }

    @RequestMapping(value = "update_information.do")
    @ResponseBody
    public ServerResponse<User> updateInformation(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (null == currentUser) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> userServerResponse = iUserService.updateInformation(user);
        if (userServerResponse.isSuccess()) {
            userServerResponse.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER,userServerResponse.getData());
        }
        return userServerResponse;
    }

    @RequestMapping(value = "get_information.do")
    @ResponseBody
    public ServerResponse<User> getInfomation(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录，需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }
}
