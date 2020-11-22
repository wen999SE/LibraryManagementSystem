package com.service;

import com.bean.Result;
import com.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {
    //用户注册
    Result register(User user);
    //用户登录
    User login(String user_id,String user_pwd);

    //修改密码
    void updateUserPwd(String user_pwd);

    //查找用户
    User getUserById(String user_id);

    //增加用户信息
    void addUser(User user);

    //查找全部用户信息
    List<User> selectAllUser();


    //修改用户信息
    void updateUser(User user);
    //删除用户信息
    void deleteUser(String user_id);


}
