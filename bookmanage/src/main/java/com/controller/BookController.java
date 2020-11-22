package com.controller;

import com.bean.Book;
import com.service.BookService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    //查找全部图书信息
    @RequestMapping("/selectAllBook")
    public List<Book> selectAllBook(){
        return bookService.selectAllBook();
    }

    //模糊查询
    @RequestMapping("/selectBookLike/{value}")
    public List<Book> selectBookLike(@PathVariable("value") String value){
        return bookService.selectBookLike(value);
    }
    //修改图书信息
    @RequestMapping(value = "/updateBook/{book_id}",method = RequestMethod.PUT)
    public List<Book> updateBook(@PathVariable("book_id")String book_id,@RequestParam("book_name")String book_name){
        bookService.updateBook(book_id,book_name);
        return bookService.selectAllBook();
    }
}
