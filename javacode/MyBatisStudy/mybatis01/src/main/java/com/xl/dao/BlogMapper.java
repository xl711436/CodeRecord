package com.xl.dao;

import com.xl.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    List<Blog> getBlogListDym(Map map);
    List<Blog> getBlogListDym2(Map map);

    int updateBlog(Map map);

    List<Blog> getBlogListForeach(Map map);

}
