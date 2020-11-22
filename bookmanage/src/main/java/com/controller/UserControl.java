package com.controller;


import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.User;
import com.service.UserService;

import ch.qos.logback.core.subst.Token.Type;

import java.util.Collection;
import java.util.List;

@Controller
public class UserControl {
	@Autowired
    UserService usertService;
	
	
    @RequestMapping("/RootUserList")
    public String list(Model model) {
    	
    	
    	List<User> userList = usertService.selectAllUser();
    	model.addAttribute("UserList",userList);
        return "/Root/UserList";//返回到list页面
    }

    @RequestMapping("/RootUserInfo/{ID}")
    public String Information(@PathVariable("ID") String ID, Model model) {
    	
    	User user=usertService.getUserById(ID);
        //查询指定id的员工,添加到empByID中,用于前端接收
    	model.addAttribute("UserInfo",user);
        return "/Root/UserInfo";//返回到编辑员工页面
    }

    @RequestMapping("/RootUserDelete/{ID}")
    public String delete(@PathVariable("ID") String ID, Model model) {
    	
    	String id = ID;
    	System.out.println(id);
        //查询指定id的员工,添加到empByID中,用于前端接收
    	usertService.deleteUser(id);
        return "redirect:/RootUserList";//返回到编辑员工页面
    }

}
