package com.scy.mall.controller.backend;

import com.scy.mall.common.Const;
import com.scy.mall.common.ResponseCode;
import com.scy.mall.common.ServerResponse;
import com.scy.mall.pojo.User;
import com.scy.mall.service.ICategoryService;
import com.scy.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Description:
 *
 * @author shichengyao
 * @Date 2017/12/6
 */
@RestController
@RequestMapping("/manage/category")
public class CategoryManageController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("add_category.do")
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") Integer parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录");
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return categoryService.addCagegory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("set_category_name.do")
    public ServerResponse updateCategory(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
        }
        if (userService.checkAdminRole(user).isSuccess()) {
            return categoryService.updateCategoryName(categoryId, categoryName);
        }else{
            return ServerResponse.createByErrorMessage("无权限操作，请登录");
        }
    }
}
