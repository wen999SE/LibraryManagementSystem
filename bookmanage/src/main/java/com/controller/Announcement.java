package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Announcement {
    @RequestMapping("/Announcement")
    public String Announcement(Model model) {

        return "/Root/Announcement";//返回到list页面
    }

    @PostMapping("/Administrator")
    public String Administrator(@RequestParam(value = "Information",required = false) String Information,
                                Model model) {

        System.out.println(Information);
        return "/Root/Administrator";//返回到list页面
    }


}
