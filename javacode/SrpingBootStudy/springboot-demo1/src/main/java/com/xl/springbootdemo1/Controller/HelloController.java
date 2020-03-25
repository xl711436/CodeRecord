package com.xl.springbootdemo1.Controller;

import com.xl.springbootdemo1.pojo.Person;
import com.xl.springbootdemo1.pojo.User;
import com.xl.springbootdemo1.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Person person;
    @Autowired
    private AsyncService curService;

    @RequestMapping("/sayhello")
    public String hello() {
        return "Hello World";
    }


    @RequestMapping("/hellojson")
    @ResponseBody
    public User hellojson()   {
        User curUser = new User(33,"合肥","bb");
        return curUser ;
    }

    @RequestMapping("/person")
    @ResponseBody
    public Person person()   {
        return person ;
    }


    @RequestMapping("/async")
    @ResponseBody
    public String asyncTest()
    {
        curService.hello();
        System.out.println("返回");
        return "返回";
    }
}