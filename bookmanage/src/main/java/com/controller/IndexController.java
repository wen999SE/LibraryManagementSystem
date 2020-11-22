package com.controller;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private UserDao userDao;

    //首页
    @RequestMapping("/main_ui")
    public String index(){
        return "main_ui";
    }

    //去登录页面
    @GetMapping("/main_login")
    public String login(){
        return "main_login";
    }

    //去注册页面
    @GetMapping("/main_register")
    public String register(){
        return "main_register";
    }

    //去用户信息修改页面
    @GetMapping("/userInfoEdition/{id}")
    public String userInfoEdition(@PathVariable("id")String id, Model model){
        User user = userDao.getUserById(id);
        model.addAttribute("user",user);
        return "userInfoEdition";
    }

}
