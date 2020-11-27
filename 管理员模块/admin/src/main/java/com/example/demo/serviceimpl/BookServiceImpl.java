package com.example.demo.serviceimpl;


import com.example.demo.dao.BookDao;
import com.example.demo.pojo.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    //查询全部图书
    @Override
    public List<Book> selectAllBook(){
        return bookDao.selectAllBook();
    }

    //查看全部图书信息
    @Override
    public List<Book> selectBookLike(String value) {
        return bookDao.selectBookLike(value);
    }

    //按ID查询图书
    @Override
    public Book selectBookByID(String value) {
        return bookDao.selectBookByID(value);
    }

    //修改图书信息
    @Override
    public void updateBook(String book_id,String book_name) {
        bookDao.updateBook(book_id,book_name);
    }
}
