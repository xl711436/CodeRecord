package com.xl.dao;

import com.xl.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImplTransation extends SqlSessionDaoSupport implements UserDaoTransation  {
    @Override
    public List<User> getUserList() {

        User addUser = new User(200,"啊啊","3343");


        this.addUser(addUser);
        this.deleteUser(200);
        return this.getUserList();

    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserDaoTransation.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserDaoTransation.class).deleteUser(id);
    }
}
