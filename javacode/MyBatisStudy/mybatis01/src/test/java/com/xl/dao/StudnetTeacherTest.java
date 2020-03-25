package com.xl.dao;

import com.xl.pojo.Student;
import com.xl.pojo.Teacher;
import com.xl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudnetTeacherTest {


    @Test
    public  void getTeacher() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher result = mapper.getTeacher(1);
            System.out.println(result);

        }
    }

    @Test
    public  void getStudent() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = mapper.getStudent();

            for (Student curStudent:studentList
                 ) {
                System.out.println(curStudent);
            }
        }
    }

    @Test
    public  void getStudentJoin() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = mapper.getStudentJoin();

            for (Student curStudent:studentList
            ) {
                System.out.println(curStudent);
            }
        }
    }

    @Test
    public  void getTeachers() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacherList = mapper.getTeachers();

            for (Teacher curTeacher:teacherList
            ) {
                System.out.println(curTeacher);
            }

        }
    }



}
