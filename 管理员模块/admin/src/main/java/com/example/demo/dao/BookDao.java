package com.example.demo.dao;


import com.example.demo.pojo.Book;
import org.apache.ibatis.annotations.*;
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
    void updateBook(@Param("book_id") String book_id, @Param("book_name") String book_name);

    //按ID查询图书信息
    @Select("select * from book where book_id =#{book_id}")
    Book selectBookByID(@Param("book_id") String book_id);

    //添加图书
    @Insert("insert into book(book_id,book_name,book_author,book_country,book_type,book_length,book_theme,book_number)" +
            "values(#{book_id},#{book_name},#{book_author},#{book_country},#{book_type},#{book_length},#{book_theme},#{book_number})")
    void RootaddBook(@Param("book_id") String book_id,
                     @Param("book_name") String book_name,
                     @Param("book_author") String book_author,
                     @Param("book_country") String book_country,
                     @Param("book_type") String book_type,
                     @Param("book_length") String book_length,
                     @Param("book_theme") String book_theme,
                     @Param("book_number") String book_number
    );

    //按照ID更新图书
    @Update("update book set book_name=#{book_name},book_author=#{book_author},book_country=#{book_country},book_type=#{book_type},book_length=#{book_length},book_theme=#{book_theme},book_number=#{book_number} where book_id=#{book_id}")
    void updateBookByID(@Param("book_id") String book_id,
                        @Param("book_name") String book_name,
                        @Param("book_author") String book_author,
                        @Param("book_country") String book_country,
                        @Param("book_type") String book_type,
                        @Param("book_length") String book_length,
                        @Param("book_theme") String book_theme,
                        @Param("book_number") String book_number
                        );

    @Delete("delete from book where book_id=#{book_id}")
    void deleteBook(@Param("book_id") String book_id);
}