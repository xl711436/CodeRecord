package com.xl.dao;

import com.xl.pojo.Blog;
import com.xl.pojo.Student;
import com.xl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlogTest {

    @Test
    public  void getBlogListDym() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
            map.put("author","aa");
            List<Blog> blogList = mapper.getBlogListDym(map);

            for (Blog curBlog:blogList
            ) {
                System.out.println(curBlog);
            }
        }
    }

    @Test
    public  void getBlogListDym2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
          //  map.put("title","bb");
            map.put("author","aa");
            List<Blog> blogList = mapper.getBlogListDym2(map);

            for (Blog curBlog:blogList
            ) {
                System.out.println(curBlog);
            }
        }
    }

    @Test
    public  void updateBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();
              map.put("title","bb");
            map.put("author","dd");
            map.put("id","55555");
            int result = mapper.updateBlog(map);


                System.out.println(result);
            sqlSession.commit();
        }
    }

    @Test
    public  void getBlogListForeach() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            HashMap map = new HashMap();

            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(33333);
            ids.add(4444);
            ids.add(55555);
            map.put("ids",ids);


            List<Blog> blogList = mapper.getBlogListForeach(map);

            for (Blog curBlog:blogList
            ) {
                System.out.println(curBlog);
            }
        }
    }


}
