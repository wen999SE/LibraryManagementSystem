package com.example.demo.controller;

import com.example.demo.dao.BookDao;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Book_Borrow;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/BookList")
    public String BookIndex(Model model) {
        List<Book> BookList = bookDao.selectAllBook();
        BookList = BookList.subList(0,10);
        model.addAttribute("BookList",BookList);
        return "/book/list";//返回到list页面
    }

    @RequestMapping("/BookList/{ID}")
    public String BookListFenye(@PathVariable("ID") int ID, Model model) {
        int last;
        last = ID+10;
        List<Book> BookList = bookDao.selectAllBook();
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

    @RequestMapping("/Bookadd")
    public String UserAddIndex() {
        return "/book/add";
    }

    @PostMapping("/RootBookAdd")
    public String BookAdd(
            @RequestParam(value = "book_id",required = false) String book_id,
            @RequestParam(value = "book_name",required = false) String book_name,
            @RequestParam(value = "book_author",required = false) String book_author,
            @RequestParam(value = "book_country",required = false) String book_country,
            @RequestParam(value = "book_type",required = false) String book_type,
            @RequestParam(value = "book_length",required = false) String book_length,
            @RequestParam(value = "book_theme",required = false) String book_theme,
            @RequestParam(value = "book_number",required = false) String book_number
    ) {
        bookDao.RootaddBook(book_id,
                book_name,
                book_author,
                book_country,
                book_type,
                book_length,
                book_theme,
                book_number);

        return "redirect:/BookList";//返回到list页面
    }

    @RequestMapping("/Bookedit/{ID}")
    public String EditIndex(@PathVariable("ID") String ID, Model model) {
        Book book=bookDao.selectBookByID(ID);
        model.addAttribute("book",book);
        return "/book/edit";//返回到编辑员工页面
    }

    @PostMapping("/Bookedit/{ID}")
    public String UserEdit(
            @PathVariable("ID") String ID,
            @RequestParam(value = "book_name",required = false) String book_name,
            @RequestParam(value = "book_author",required = false) String book_author,
            @RequestParam(value = "book_country",required = false) String book_country,
            @RequestParam(value = "book_type",required = false) String book_type,
            @RequestParam(value = "book_length",required = false) String book_length,
            @RequestParam(value = "book_theme",required = false) String book_theme,
            @RequestParam(value = "book_number",required = false) String book_number,
            Model model
    ) {
       bookDao.updateBookByID(ID,
               book_name,
               book_author,
               book_country,
               book_type,
               book_length,
               book_theme,
               book_number
       );

        return "redirect:/BookList";//返回到list页面
    }

    @RequestMapping("/BookDelete/{ID}")
    public String delete(@PathVariable("ID") String ID, Model model) {
        String id = ID;
        System.out.println(id);
        //查询指定id的员工,添加到empByID中,用于前端接收
        bookDao.deleteBook(ID);
        return "redirect:/BookList";//返回到编辑员工页面
    }

    @PostMapping("/BookFind")
    public String BookFind(@RequestParam(value = "name",required = false) String name,
                           Model model) {
        System.out.println(name);
        List<Book> bookList = bookDao.selectBookLike(name);
        model.addAttribute("BookList",bookList);
        return "/book/find";//返回到list页面
    }



}
