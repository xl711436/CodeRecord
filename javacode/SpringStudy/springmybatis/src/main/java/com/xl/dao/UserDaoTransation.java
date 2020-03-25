package com.xl.dao;

import com.xl.pojo.User;

import java.util.List;

public interface UserDaoTransation {

    List<User> getUserList();

    int addUser(User user);

    int deleteUser(int id);


}
