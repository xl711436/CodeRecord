package com.xl.springbootdemo1.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xl.springbootdemo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}

