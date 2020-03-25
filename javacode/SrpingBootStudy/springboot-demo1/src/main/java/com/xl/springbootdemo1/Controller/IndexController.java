package com.xl.springbootdemo1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("userName", "index");
        return view;
    }

    //真实访问地址 : 项目名/HelloController/hello
    @RequestMapping("/index1")
    public String sayHello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("userName","index1");
        //web-inf/jsp/hello.jsp
        return "index";
    }
}