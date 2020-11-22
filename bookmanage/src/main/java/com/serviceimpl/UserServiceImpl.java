package com.serviceimpl;

import com.bean.Result;
import com.bean.User;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = RuntimeException.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result register(User user){
        Result result = new Result();

        String id = user.getUser_id();
        String pwd = user.getUser_pwd();

        try{
            //先检查该用户是否被注册过
            User user2 = userDao.login(id,pwd);
            if(user2 != null){
                result.setMsg("该用户已被创建");
                result.setStatus("400");
                return result;
            }else {
                //没被创建过就注册
                userDao.register(user);
                result.setMsg("注册成功");
                result.setStatus("200");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setStatus("400");
        }
        return result;
    }

    @Override
    public User login(String user_id, String user_pwd){
        Result result = new Result();
        User user = new User();

        try{
            user = userDao.login(user_id, user_pwd);
            if (user == null){
                result.setMsg("用户名或者密码错误");
                result.setStatus("400");
                return user;
            }else {
                result.setMsg("登录成功");
                result.setStatus("200");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setStatus("400");
        }
        return user;
    }

    //修改用户密码
    @Override
    public void updateUserPwd(String user_pwd) {
        userDao.updateUserPwd(user_pwd);
    }

    //增加用户信息
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    //查询所有用户信息
    @Override
    public List<User> selectAllUser(){
        return userDao.selectAllUser();
    }

    //查询单个用户信息
    @Override
    public User getUserById(String user_id){
        return userDao.getUserById(user_id);
    }

    //修改个人信息
    @Override
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    //删除用户信息
    @Override
    public void deleteUser(String user_id) {
        userDao.deleteUser(user_id);
    }

}
