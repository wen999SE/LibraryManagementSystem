package com.example.demo.service;


import com.example.demo.pojo.Book;

import java.util.List;

public interface BookService {
    //查询全部图书
    List<Book> selectAllBook();

    //图书模糊查询
    List<Book> selectBookLike(String value);

    //按ID查询图书信息
    Book selectBookByID(String book_id);

    //修改图书信息
    void updateBook(String book_id, String book_name);
}
