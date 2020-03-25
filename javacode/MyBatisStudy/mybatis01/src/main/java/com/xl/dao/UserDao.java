package com.xl.dao;

import com.xl.pojo.User;
import com.xl.pojo.UserExtra;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);


    List<User> getUserByMap(Map<String,Object> map);
    int addUserByMap(Map<String,Object> map);

    List<User> getUserByMapLike(Map<String,Object> map);


    UserExtra getUserByIdExtra(int id);


    List<User> getUserByMapLimit(Map<String,Integer> map);

    List<User> getUserByMapRowBounds();

}
