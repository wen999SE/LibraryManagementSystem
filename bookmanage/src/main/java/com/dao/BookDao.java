package com.dao;

import com.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookDao {
    //查询全部图书
    @Select("select * from book")
    List<Book> selectAllBook();

    //模糊查询
    @Select("select * from book where book_name like CONCAT('%',#{book_name},'%') ")
    List<Book> selectBookLike(@Param("book_name") String value);

    //修改图书信息
    @Update("update book set book_name=#{book_name} where book_id=#{book_id}")
    void updateBook(@Param("book_id")String book_id,@Param("book_name")String book_name);
}