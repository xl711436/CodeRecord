package com.xl.springbootdemo1.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {


    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/testConnection")
    @ResponseBody
    public void testConnection()   {
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("test connection" + connection);
            //关闭连接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/add")
    public String addUser(){
        String sql = "insert into user(id, name,pwd)" +
                " values ('44','24736743@qq.com','dfdfd')";
        jdbcTemplate.update(sql);
        //查询
        return "addOk";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update user set name=?,pwd=? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "得分333";
        objects[1] = "233";
        jdbcTemplate.update(sql,objects);
        return "updateOk";
    }

    //删除用户
    @GetMapping("/delete/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "deleteOk";
    }



    @RequestMapping("/testDruidConnection")
    @ResponseBody
    public void testDruidConnection()  throws SQLException {
        //看一下默认数据源
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        //关闭连接
        connection.close();
    }


}
