package com.example.demo.controller;


import com.example.demo.dao.BorrowDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Book_Borrow;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
public class UserListController {
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BorrowDao borrowDao;

    @RequestMapping("/UserList")
    public String UserListIndex(Model model) {
        List<User> userList = userDao.selectAllUser();
        //userList = userList.subList(0,10);
        model.addAttribute("UserList",userList);
        return "/user/list";//返回到list页面
    }

    @RequestMapping("/UserList/{ID}")
    public String UserListFenye(@PathVariable("ID") int ID, Model model) {
        int last;
        last = ID+10;
        List<User> userList = userDao.selectAllUser();
        if(ID > userList.size())
            return "/user/list";
        if(last > userList.size()) {
            last = userList.size();
            userList = userList.subList(ID,last);
        }
        else
            userList = userList.subList(ID,last);
        model.addAttribute("UserList",userList);
        return "/user/list";//返回到list页面
    }

    @PostMapping("/Find")
    public String UserFind(@RequestParam(value = "name",required = false) String name,
                            Model model) {
        List<User> userList = userDao.getUserByName(name);
        model.addAttribute("UserList",userList);
        return "/user/find";//返回到list页面
    }

    @RequestMapping("/Useredit/{ID}")
    public String UserEditIndex(@PathVariable("ID") String ID, Model model) {
        User user=userDao.getUserById(ID);
        //查询指定id的员工,添加到empByID中,用于前端接收
        model.addAttribute("UserInfo",user);
        return "/user/edit";//返回到编辑员工页面
    }

    @PostMapping("/RootUserUpdate/{ID}")
    public String UserEdit(
            @PathVariable("ID") String ID,
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "user_email",required = false) String user_email,
            @RequestParam(value = "user_age",required = false) String user_age,
            @RequestParam(value = "user_birthday",required = false) String user_birthday,
            @RequestParam(value = "user_phone",required = false) String user_phone,
            @RequestParam(value = "user_address",required = false) String user_address,
            @RequestParam(value = "user_sex",required = false) String user_sex,
            @RequestParam(value = "user_describe",required = false) String user_describe,
            @RequestParam(value = "user_pwd",required = false) String user_pwd,
            Model model
    ) {
        System.out.println("value:"+ID);
        userDao.RootUpdateUser(ID,user_name,user_email,user_age,user_birthday,
                user_phone,user_address,user_sex,user_describe,user_pwd);
        return "redirect:/UserList";//返回到list页面
    }

    @RequestMapping("/Useradd")
    public String UserAddIndex() {
        return "/user/add";
    }

    @PostMapping("/RootUserAdd")
    public String UserAdd(
            @RequestParam(value = "user_id",required = false) String user_id,
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "user_email",required = false) String user_email,
            @RequestParam(value = "user_age",required = false) String user_age,
            @RequestParam(value = "user_birthday",required = false) String user_birthday,
            @RequestParam(value = "user_phone",required = false) String user_phone,
            @RequestParam(value = "user_address",required = false) String user_address,
            @RequestParam(value = "user_sex",required = false) String user_sex,
            @RequestParam(value = "user_describe",required = false) String user_describe,
            @RequestParam(value = "user_pwd",required = false) String user_pwd

    ) {
        Date date = new Date();
        String user_borrowid = ""+ date.toString();

        userDao.RootaddUser(user_id,
                user_name,
                user_email,
                user_age,
                user_birthday,
                user_borrowid,
                user_phone,
                user_address,
                user_sex,
                user_describe,
                user_pwd
        );
        return "redirect:/UserList";//返回到list页面
    }




    @RequestMapping("/RootUserDelete/{ID}")
    public String delete(@PathVariable("ID") String ID, Model model) {
        String id = ID;
        System.out.println(id);
        //查询指定id的员工,添加到empByID中,用于前端接收
        userDao.deleteUser(id);
        return "redirect:/UserList";//返回到编辑员工页面
    }
    
    
    @RequestMapping("/UserHistory/{name}")
    public String History(@PathVariable("name") String name, Model model) {
    		
    	System.out.println(name);
    	List<Book_Borrow> BorrowsList = borrowDao.selectAllBorrowBookByName(name);
        List<Borrow> BorrowsNowList = borrowDao.selectAllNowBorrowBookByName(name);
    	model.addAttribute("BorrowsList",BorrowsList);
        model.addAttribute("BorrowsNowList",BorrowsNowList);
        return "/user/history";//返回到list页面
    }
    
    
}
