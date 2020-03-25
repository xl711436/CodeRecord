package com.xl.dao;

import com.xl.pojo.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudent();
    List<Student> getStudentJoin();

}
