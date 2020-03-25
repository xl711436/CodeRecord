package com.xl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {


    //   http://localhost:8082/User/t1?name=3
    @RequestMapping("/t1")
    public String test1(String name, Model model)
    {
        model.addAttribute("msg",name);
        return "hello";
    }

    //  http://localhost:8082/User/t2?username=5
    @RequestMapping("/t2")
    public String test2(@RequestParam("username") String name,Model model)
    {
        model.addAttribute("msg",name);
        return "hello";
    }

  //http://localhost:8082/User/user?name=kuangshen&id=1&age=15
    @RequestMapping("/user")
    public String user(User user,Model model){

        model.addAttribute("msg",user.toString());
        return "hello";
    }

    @RequestMapping("/json1")

    public String json1(Model model) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User curUser = new User(33,"合肥",22);

        model.addAttribute("msg",mapper.writeValueAsString(curUser));
        return "hello";
    }


    @RequestMapping("/json2")
    @ResponseBody
    public String json2() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        User curUser = new User(33,"合肥",22);


        return mapper.writeValueAsString(curUser);
    }



    @RequestMapping("/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user1 = new User(33,"合肥",22);
        User user2 = new User(43,"合肥",22);
        User user3 = new User(53,"合肥",22);
        User user4 = new User(63,"合肥",22);
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(list);
        return str;
    }

    @RequestMapping("/json4")
    @ResponseBody
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }


    @RequestMapping("/json5")
    @ResponseBody
    public String json5()  {

        //创建一个对象
        User user11 = new User(33,"合肥",22);
        User user12 = new User(43,"合肥",22);
        User user13 = new User(53,"合肥",22);
        User user14 = new User(63,"合肥",22);
        List<User> list = new ArrayList<User>();
        list.add(user11);
        list.add(user12);
        list.add(user13);
        list.add(user14);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user11);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user12);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return str1;
    }

}
