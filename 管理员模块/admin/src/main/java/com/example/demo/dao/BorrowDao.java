package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.Book_Borrow;
import com.example.demo.pojo.Borrow;
import com.example.demo.pojo.Return;
import com.example.demo.pojo.User;

@Mapper
@Repository
public interface BorrowDao {
	 //查询全部借阅信息
    @Select("select * from book_borrow")
    List<Book_Borrow> selectAllBorrowInfo();
    
    //添加借阅信息
    @Insert("insert into book_borrow(book_borrow_id,book_borrow_name,borrow_user_name,borrow_time,return_time)" +
            "values(#{book_borrow_id},#{book_borrow_name},#{borrow_user_name},#{borrow_time},#{return_time})")
    void addBorrowInfo(@Param("book_borrow_id") String book_borrow_id,
                       @Param("book_borrow_name") String book_borrow_name,
                       @Param("borrow_user_name") String borrow_user_name,
                       @Param("borrow_time") String borrow_time,
                       @Param("return_time") String return_time);
    
    
  //查询所有正在借阅图书的信息
    @Select("select * from book_borrow where borrow_user_name = #{borrow_user_name}" )
    List<Book_Borrow> selectAllBorrowBookByName(@Param("borrow_user_name") String borrow_user_name);

  @Select("select * from book_borrow where book_borrow_name = #{book_borrow_name}" )
  List<Book_Borrow> selectAllBorrowBookByBookName(@Param("book_borrow_name") String book_borrow_name);
    
    //查询所有正在借阅图书的信息
    @Select("select * from borrow")
    List<Borrow> selectAllBorrowBook();

    //按名字查询正在借阅图书的信息
    @Select("select * from borrow where borrow_user_name = #{borrow_user_name}")
    List<Borrow> selectAllNowBorrowBookByName(@Param("borrow_user_name") String borrow_user_name);

    //按书名查询正在借阅图书的信息
    @Select("select * from borrow where book_borrow_name = #{book_borrow_name}")
    Borrow selectAllNowBorrowBookByBookName(@Param("book_borrow_name") String book_borrow_name);
    
    //删除正在借阅图书的信息
    @Delete("delete from borrow where book_borrow_name=#{book_borrow_name}")
    void deleteBorrowBook(@Param("book_borrow_name") String book_borrow_name);
    
    //增加正在借阅图书的信息
    @Insert("insert into borrow(book_borrow_name,borrow_user_name,borrow_time)" +
            "values(#{book_borrow_name},#{borrow_user_name},#{borrow_time})")
    void addBorrowBook(@Param("book_borrow_name") String book_borrow_name,
                       @Param("borrow_user_name") String borrow_user_name,
                       @Param("borrow_time") String borrow_time);
	
  //查询所有已归还图书的信息
    @Select("select * from return")
    List<Return> selectAllReturn();
    
  //增加已归还图书的信息
    @Insert("insert into return(book_borrow_name,borrow_user_name,return_time)" +
            "values(#{book_borrow_name},#{borrow_user_name},#{return_time})")
    void addReturn(@Param("book_borrow_name") String book_borrow_name,
                   @Param("borrow_user_name") String borrow_user_name,
                   @Param("return_time") String return_time);
    
  //修改图书信息
    @Update("update book set book_number=#{book_number} where book_name=#{book_name}")
    void updateBook(@Param("book_name") String book_name, @Param("book_number") String book_number);

    //查询所有日期数据
  @Select("select * from book_borrow where borrow_time like CONCAT('%',#{borrow_time},'%') ")
  List<Book_Borrow> selectAllBorrowInfoByDate(@Param("borrow_time") String borrow_time);
}
