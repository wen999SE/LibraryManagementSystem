package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    // 注册
    @Insert("insert into user(user_id,user_name,user_email,user_pwd) values (#{user_id},#{user_name},#{user_email},#{user_pwd})")
    void register(User user);

    // 登陆
    @Select("select * from user where user_id=#{user_id} and user_pwd=#{user_pwd}")
    User login(@Param("user_id") String user_id,@Param("user_pwd") String user_pwd);

    //修改密码
    @Update("update user set user_pwd=#{user_pwd}")
    void updateUserPwd(@Param("user_pwd")String user_pwd);

    //查找
    @Select("select * from user where user_id = #{user_id}")
    User getUserById(@Param("user_id")String user_id);

    //增加用户信息
    @Insert("insert into user(user_id,user_name,user_sex,user_age,user_email,user_pwd,user_birthday,user_borrowid,user_phone,user_address,user_describe)" +
            "values(#{user_id},#{user_name},#{user_sex},#{user_age},#{user_email},#{user_pwd},#{user_birthday},#{user_borrowid},#{user_phone},#{user_address},#{user_describe})")
    void addUser(User user);

    //查找全部用户信息
    @Select("select * from user")
    List<User> selectAllUser();


    //修改用户信息
    @Update("update user set user_name=#{user_name},user_name=#{user_sex},user_age=#{user_age},user_email=#{user_email},user_birthday=#{user_birthday},user_borrowid=#{user_borrowid},user_phone=#{user_phone},user_address=#{user_address},user_describe=#{user_describe} where user_id=#{user_id}")
    void updateUser(User user);

    //删除用户信息
    @Delete("delete from user where user_id=#{user_id}")
    void deleteUser(@Param("user_id")String user_id);
}
