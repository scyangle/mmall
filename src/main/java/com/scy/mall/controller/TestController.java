package com.scy.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shichengyao on 2017/6/15.
 */
@Controller
@RequestMapping("/test/")
public class TestController {
    @RequestMapping("array.do")
    @ResponseBody
    public String arrayTest(String[] arr) {
        StringBuilder strB = new StringBuilder();
        for (String temp : arr) {
            strB.append(temp).append("");
        }
        return strB.toString();
    }
}
