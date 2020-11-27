package com.example.demo.controller;

import com.example.demo.dao.NoticeDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.Notice;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeDao noticeDaoo;

    @RequestMapping("/noticeIndex")
    public String UserIndex(Model model) {

        return "/notice/notice";//返回到list页面
    }

    @PostMapping("/notice")
    public String FindIndex(@RequestParam(value = "info",required = false) String info,
                            Model model) {
        noticeDaoo.updateNoticeById("1",info);
        System.out.println("添加内容："+info);
        return "redirect:/noticeIndex";
    }
}
