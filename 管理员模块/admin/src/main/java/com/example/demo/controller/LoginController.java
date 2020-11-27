package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        //如果用户名和密码正确
        if ("admin".equals(username) && "123456".equals(password))
            return "dashboard";//跳转到dashboard页面
            //如果用户名或者密码不正确
        else {
            model.addAttribute("msg", "用户名或者密码错误");//显示错误信息
            return "index";//跳转到首页
        }
    }

    @RequestMapping("/Index")
    public String UserIndex(Model model) {

        return "dashboard";//返回到list页面
    }
}