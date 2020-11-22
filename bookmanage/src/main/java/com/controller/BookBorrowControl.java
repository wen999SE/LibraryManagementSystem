package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.User;
import com.service.BookService;
import com.service.UserService;

@Controller
public class BookBorrowControl {
	
	@Autowired
    BookService bookService;
	@RequestMapping("/RootBookBorrow")
    public String list(Model model) {
        return "/Root/BookBorrow";//返回到list页面
    }

}
