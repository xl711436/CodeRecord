package com.xl.springbootdemo1.Controller;

import com.github.pagehelper.PageHelper;
import com.xl.springbootdemo1.Mapper.UserMapper;
import com.xl.springbootdemo1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MyBatisController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/GetUserList")
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @RequestMapping("/GetUserListPage")
    public List<User> getUserListPage(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "2") int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.getUserList();
    }

    @RequestMapping("/GetUserById")
    public User GetUserById(int id) {
        return userMapper.getUserById(id);
    }

    @RequestMapping("/AddUser")
    public int AddUser(User user) {
        return userMapper.addUser(user);
    }

    @RequestMapping("/UpdateUser")
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @RequestMapping("/DeleteUser")
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }



}

