package com.service;

import com.bean.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {
    //查询全部图书
    List<Book> selectAllBook();

    //图书模糊查询
    List<Book> selectBookLike(String value);

    //修改图书信息
    void updateBook(String book_id,String book_name);
}
