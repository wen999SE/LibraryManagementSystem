package com.example.demo.dao;


import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    // 注册
    @Insert("insert into user(user_id,user_name,user_email,user_pwd) values (#{user_id},#{user_name},#{user_email},#{user_pwd})")
    void register(User user);

    // 登陆
    @Select("select * from user where user_id=#{user_id} and user_pwd=#{user_pwd}")
    User login(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);

    //修改密码
    @Update("update user set user_pwd=#{user_pwd}")
    void updateUserPwd(@Param("user_pwd") String user_pwd);

    //查找
    @Select("select * from user where user_id = #{user_id}")
    User getUserById(@Param("user_id") String user_id);

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
    void deleteUser(@Param("user_id") String user_id);

    @Update("update user set user_name=#{user_name},user_email=#{user_email},user_age=#{user_age},user_birthday=#{user_birthday},user_phone=#{user_phone},user_address=#{user_address},user_sex=#{user_sex},user_describe=#{user_describe},user_pwd=#{user_pwd} where user_id=#{user_id}")
    void RootUpdateUser(@Param("user_id") String user_id,
                        @Param("user_name") String user_name,
                        @Param("user_email") String user_email,
                        @Param("user_age") String user_age,
                        @Param("user_birthday") String user_birthday,
                        @Param("user_phone") String user_phone,
                        @Param("user_address") String user_address,
                        @Param("user_sex") String user_sex,
                        @Param("user_describe") String user_describe,
                        @Param("user_pwd") String user_pwd
    );

    @Insert("insert into user(user_id,user_name,user_sex,user_age,user_email,user_pwd,user_birthday,user_borrowid,user_phone,user_address,user_describe)" +
            "values(#{user_id},#{user_name},#{user_sex},#{user_age},#{user_email},#{user_pwd},#{user_birthday},#{user_borrowid},#{user_phone},#{user_address},#{user_describe})")

    void RootaddUser(@Param("user_id") String user_id,
                     @Param("user_name") String user_name,
                     @Param("user_email") String user_email,
                     @Param("user_age") String user_age,
                     @Param("user_birthday") String user_birthday,
                     @Param("user_borrowid") String user_borrowid,
                     @Param("user_phone") String user_phone,
                     @Param("user_address") String user_address,
                     @Param("user_sex") String user_sex,
                     @Param("user_describe") String user_describe,
                     @Param("user_pwd") String user_pwd
    );


    //模糊查找用户信息
    @Select("select * from user where user_name like CONCAT('%',#{user_name},'%') ")
    List<User> getUserByName(@Param("user_name") String user_name);
}
