package com.xl.dao;

import com.xl.pojo.User;
import com.xl.pojo.UserAnno;
import com.xl.pojo.UserExtra;
import com.xl.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class UserDaoTest {
    @Test
    public  void getUserList(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);

            List<User> curUserList = mapper.getUserList();

            List<User> curUserList1 = sqlSession.selectList("com.xl.dao.UserDao.getUserList");

            for(User curUser :  curUserList)
            {
                System.out.println(curUser);
            }

            for(User curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }

    }

    @Test
    public  void getUserById(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
            User curUser = mapper.getUserById(3);
            System.out.println(curUser);
        }
    }

    @Test
    public  void addUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
           int result =   mapper.addUser(new User(3011,"哈哈哈","3432"));

           System.out.println(result);
            sqlSession.commit();
        }
    }

    @Test
    public  void updateUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
            int result =   mapper.updateUser(new User(3000,"哈哈哈1","3432"));

            System.out.println(result);
            sqlSession.commit();
        }
    }
    @Test
    public  void deleteUser(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
            int result =   mapper.deleteUser(3000);

            System.out.println(result);
            sqlSession.commit();
        }
    }

    @Test
    public  void addUserByMap(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);

            Map<String,Object> curMap = new HashMap<String,Object>();
            curMap.put("userid",3210);
            curMap.put("username","32dfdf");
            int result =   mapper.addUserByMap(curMap);

            System.out.println(result);
            sqlSession.commit();
        }
    }


    @Test
    public  void getUserByMap(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);

            Map<String,Object> curMap = new HashMap<String,Object>();
            curMap.put("username","哈哈哈");
            List<User> curUserList1 =   mapper.getUserByMap(curMap);

            for(User curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }
    @Test
    public  void getUserByMapLike(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);

            Map<String,Object> curMap = new HashMap<String,Object>();
            curMap.put("username","ff");
            List<User> curUserList1 =   mapper.getUserByMapLike(curMap);

            for(User curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }


    @Test
    public  void getUserByIdExtra(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
            UserExtra curUser = mapper.getUserByIdExtra(3);
            System.out.println(curUser);
        }
    }

    @Test
    public  void testLog4j(){
        Logger curLogger =   Logger.getLogger(UserDaoTest.class);
        curLogger.info("aaa");
        curLogger.trace("bbb");
        curLogger.debug("ccc");
        curLogger.error("ddd");
    }

    @Test
    public  void getUserByMapLimit(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);

            Map<String,Integer> curMap = new HashMap<String,Integer>();
            curMap.put("startIndex",1);
            curMap.put("pageSize",2);
            List<User> curUserList1 =   mapper.getUserByMapLimit(curMap);

            for(User curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }

    @Test
    public  void getUserByMapRowBounds(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            RowBounds rowBounds =new RowBounds(2,3);
            List<User> curUserList1 = sqlSession.selectList("com.xl.dao.UserDao.getUserList",null,rowBounds);

            for(User curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }




    @Test
    public  void getUserAnno(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDaoAnno  mapper = sqlSession.getMapper(UserDaoAnno.class);
            List<UserAnno> curUserList1 = mapper.getUserListAnno();
            for(UserAnno curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }

    @Test
    public  void getUserByID(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDaoAnno  mapper = sqlSession.getMapper(UserDaoAnno.class);
            List<UserAnno> curUserList1 = mapper.getUserByID(3,"32dfdf");
            for(UserAnno curUser :  curUserList1)
            {
                System.out.println(curUser);
            }
        }
    }

    @Test
    public  void addUserAnno(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDaoAnno  mapper = sqlSession.getMapper(UserDaoAnno.class);
            int result = mapper.addUserAnno(new UserAnno(3202,"bbaa啊啊","ddf"));
             System.out.println(result);
            sqlSession.commit();
        }


        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDaoAnno  mapper = sqlSession.getMapper(UserDaoAnno.class);
            int result = mapper.updateUserAnno(new UserAnno(3202,"bbaa111啊啊","ddf"));
            System.out.println(result);
            sqlSession.commit();
        }

        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDaoAnno  mapper = sqlSession.getMapper(UserDaoAnno.class);
            int result = mapper.deleteUserAnno(3202);
            System.out.println(result);
            sqlSession.commit();
        }
    }





    @Test
    public  void cacheTest(){

        List<User> curUserList1;
        List<User> curUserList;

        try(SqlSession sqlSession = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession.getMapper(UserDao.class);
             curUserList = mapper.getUserList();

            for(User curUser :  curUserList)
            {
                System.out.println(curUser);
            }
        }

        try(SqlSession sqlSession2 = MybatisUtils.getSqlSession())
        {
            UserDao  mapper = sqlSession2.getMapper(UserDao.class);
             curUserList1 = mapper.getUserList();

            for(User curUser :  curUserList)
            {
                System.out.println(curUser);
            }
        }

        if(  curUserList ==   curUserList1)
        {
            System.out.println("true");
        }
    }





}
