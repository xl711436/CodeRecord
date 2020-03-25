package com.xl.dao;

import com.xl.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserDaoImpl  implements UserDao{

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSession = sqlSessionTemplate;
    }



    @Override
    public List<User> getUserList() {
       UserDao userDao = sqlSession.getMapper(UserDao.class);
       return userDao.getUserList();
    }
}
