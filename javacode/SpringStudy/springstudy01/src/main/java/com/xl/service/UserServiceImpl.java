package com.xl.service;

import com.xl.dao.UserDao;

public class UserServiceImpl implements  UserService{


    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
