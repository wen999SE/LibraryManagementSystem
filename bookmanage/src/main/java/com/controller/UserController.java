package com.controller;

import com.bean.User;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService usertService;

    //注册
    @PostMapping("/main_register")
    String register(User user){
        usertService.register(user);
        return "redirect:/";
    }

    //登录
    @PostMapping("/main_login")
    String login(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd,Model model){
        User user = usertService.login(user_id,user_pwd);
        model.addAttribute("user",user);
        return "userInfoShow";
    }

    //增加用户信息
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    @ResponseBody
    public User addUser(User user){
        usertService.addUser(user);
        return user;
    }
    //修改用户信息
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public User updateUser(User user1,Model model) {
        usertService.updateUser(user1);
        User user = usertService.getUserById(user1.getUser_id());
//        model.addAttribute("user",user);
        return user;
    }

    //删除用户信息
    @RequestMapping(value = "/deleteUser/{u_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public List<User> deleteUser(@PathVariable("user_id") String user_id){
        usertService.deleteUser(user_id);
        return usertService.selectAllUser();
    }

    //查询所有用户信息
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public List<User> list(){
        return usertService.selectAllUser();
    }

    //查询单个用户信息
    @RequestMapping("/getUser")
    public String getUser(Model model){
        User user = usertService.getUserById("1");
        model.addAttribute("user",user);
        return "userInfoShow";
    }

}
