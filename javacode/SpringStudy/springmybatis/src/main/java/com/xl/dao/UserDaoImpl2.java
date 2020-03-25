package com.xl.dao;

import com.xl.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl2 extends SqlSessionDaoSupport implements UserDao  {
    @Override
    public List<User> getUserList() {
        return getSqlSession().getMapper(UserDao.class).getUserList();

    }
}
