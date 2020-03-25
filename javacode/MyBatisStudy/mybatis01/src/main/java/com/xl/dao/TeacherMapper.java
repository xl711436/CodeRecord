package com.xl.dao;

import com.xl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid")int id);

    List<Teacher> getTeachers();

}
