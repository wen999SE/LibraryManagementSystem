package com.example.demo.controller;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BorrowDao;
import com.example.demo.dao.NoticeDao;
import com.example.demo.dao.UserDao;
import com.example.demo.pojo.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class Index {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private NoticeDao noticeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    String userid;

    @GetMapping("/")
    public String login(){
        return "/login_register/main_login";
    }

    //去注册页面
    @GetMapping("/register")
    public String register(){
        return "/login_register/main_register";
    }

    //注册
    @PostMapping("/main_register")
    String register(User user,String user_id,Model model){
        if (userService.getUserById(user_id)==null){
            userService.register(user);
            model.addAttribute("msg1","注册成功，请登录!");
            return "/login_register/main_login";
        }else {
            model.addAttribute("msg","用户ID已存在，请重新输入！");
            return "/login_register/main_register";
        }
    }

    //登录
    @PostMapping("/main_login")
    String login(@RequestParam("user_id") String user_id,
                 @RequestParam("user_pwd") String user_pwd, Model model){
        User user = userService.login(user_id,user_pwd);
        System.out.println("登录成功："+user);
        if (user == null){
            model.addAttribute("msg","用户名或密码错误!");
            return "/login_register/main_login";
        }else {
            userid = user.getUser_id();
            System.out.println(userid);
            model.addAttribute("user",user);
            return "redirect:/Index";
        }
    }

    //跳转到用户界面
    @RequestMapping("/Index")
    public String UserIndex(Model model) {
        Notice notice = noticeDao.getNoticeById("1");
        model.addAttribute("notice",notice);
        return "/notice/notice";
    }

    //跳转到用户信息界面
    @RequestMapping("/UserInfo")
    public String UserInfo(Model model) {
        User user = userDao.getUserById(userid);
        model.addAttribute("User",user);
        return "/userAll/Userlist";
    }

    //跳转到用户信息编辑
    @RequestMapping("/Useredit/{ID}")
    public String Useredit(@PathVariable("ID") String ID, Model model) {
        User user=userDao.getUserById(ID);
        model.addAttribute("UserInfo",user);
        return "/user/edit";//返回到编辑员工页面
    }

    //修改用户信息
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
        return "redirect:/UserInfo";//返回到list页面
    }

    @RequestMapping("/UserHistory")
    public String History(Model model) {
        User user=userDao.getUserById(userid);
        List<Book_Borrow> BorrowsList = borrowDao.selectAllBorrowBookByName(user.getUser_name());
        List<Borrow> BorrowsNowList = borrowDao.selectAllNowBorrowBookByName(user.getUser_name());
        model.addAttribute("BorrowsList",BorrowsList);
        model.addAttribute("BorrowsNowList",BorrowsNowList);
        return "/user/history";//返回到list页面
    }

    @RequestMapping("/ReturnBook/{name}")
    public String ReturnBook(@PathVariable("name") String name, Model model) {
        System.out.println(name);
        Date date = new Date();
        Borrow Book = borrowDao.selectAllNowBorrowBookByBookName(name);
        System.out.println(date);
        System.out.println(Book);
        //borrowDao.addReturn(Book.getBook_borrow_name(),Book.getBorrow_user_name(),date.toString());
        borrowDao.deleteBorrowBook(name);
        borrowDao.updateBook(name,"1");
        return "redirect:/MyBook";
    }

    @RequestMapping("/BookList")
    public String BookIndex(Model model) {
        List<Book> BookList = bookDao.selectBookByNumber("1");
        BookList = BookList.subList(0,10);
        model.addAttribute("BookList",BookList);
        return "/book/list";//返回到list页面
    }

    @RequestMapping("/BookBorrow/{name}")
    public String BorrowBook(@PathVariable("name") String name, Model model) {
        User user=userDao.getUserById(userid);
        List<Borrow> borrowList=borrowDao.selectAllNowBorrowBookByName(user.getUser_name());
        if(borrowList.size() == 3)
        {
            return "/book/Error";
        }
        borrowDao.addBorrowInfo("x",name,user.getUser_name(),"2020/11/26","x");
        borrowDao.addBorrowBook(name,user.getUser_name(),"2020/11/26");
        borrowDao.updateBook(name, "0");
        return "redirect:/BookList";
    }

    @PostMapping("/BookFind")
    public String BookFind(@RequestParam(value = "name",required = false) String name,
                           Model model) {
        System.out.println(name);
        List<Book> bookList = bookDao.selectBookLike(name);
        model.addAttribute("BookList",bookList);
        return "/book/find";//返回到list页面
    }

    @RequestMapping("/BookList/{ID}")
    public String BookListFenye(@PathVariable("ID") int ID, Model model) {
        int last;
        last = ID+10;
        List<Book> BookList = bookDao.selectBookByNumber("1");
        if(ID > BookList.size())
            return "/book/list";
        if(last > BookList.size()) {
            last = BookList.size();
            BookList = BookList.subList(ID,last);
        }
        else
            BookList = BookList.subList(ID,last);
        model.addAttribute("BookList",BookList);
        return "/book/list";//返回到list页面
    }

    @RequestMapping("/MyBook")
    public String MyBook(Model model) {
        User user=userDao.getUserById(userid);
        List<Borrow> BorrowsNowList = borrowDao.selectAllNowBorrowBookByName(user.getUser_name());
        model.addAttribute("BorrowsNowList",BorrowsNowList);
        return "/book/Mybook";
    }
}
