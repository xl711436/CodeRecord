package com.xl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";
    }

    @RequestMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){

        model.addAttribute("msg",a+ b);
        //web-inf/jsp/hello.jsp
        return "hello";
    }


    @RequestMapping("/t1")
    public String test1(){
        //转发
        return "/hello";
    }

    @RequestMapping("/t2")
    public String test2(){
        //转发二
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/t3")
    public String test3(){
        //重定向
        return "redirect:/WEB-INF/jsp/hello.jsp";
    }
}
