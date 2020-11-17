package com.example.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.example.demo.pojo.User;

@Mapper
public interface UserMapper {
	@Select("select * from user")
	List<User> findAll();
	
	@Select("INSERT INTO user (ID,Name,Password,Email) VALUES (#{ID},#{Name},#{Password},#{Email});")
	User AddUser(@Param("ID")String ID,@Param("Name")String Name,@Param("Password")String Password,@Param("Email")String Email);
}