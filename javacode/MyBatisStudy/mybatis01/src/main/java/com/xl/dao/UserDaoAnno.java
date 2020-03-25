package com.xl.dao;

import com.xl.pojo.UserAnno;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDaoAnno {


    @Select("select * from user")
    List<UserAnno> getUserListAnno();

    @Select("select * from user where id = #{id} or name =#{name}")
    List<UserAnno> getUserByID(@Param("id") int id,@Param("name") String name);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUserAnno(UserAnno user);

    @Update("update user set name=#{name},pwd=#{pwd} where id= #{id}")
    int updateUserAnno(UserAnno user);

    @Delete("delete from user where id=#{id}")
    int deleteUserAnno(@Param("id")int id);

}
