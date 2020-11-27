package com.example.demo.controller;

import com.example.demo.dao.BorrowDao;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Book_Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class statisticsController {
    @Autowired
    private BorrowDao borrowDao;

    @RequestMapping("/statistics")
    public String statisticsIndex(Model model) {
        String day = "2020/11/26";
        String month = "11";
        List<Book_Borrow> BorrowList = borrowDao.selectAllBorrowInfoByDate(day);
        model.addAttribute("Day",BorrowList.size());
        System.out.println(BorrowList.size());
        BorrowList = borrowDao.selectAllBorrowInfoByDate(month);
        model.addAttribute("Month",BorrowList.size());
        System.out.println(BorrowList.size());
        return "/statistics/list";//返回到list页面
    }

}
