package cn.yinmi.items.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class demoController {
    @RequestMapping("/index")
    @ResponseBody
    public String demo1(){
        return "helloworld";
    }
    @RequestMapping("/select12")
    @ResponseBody
    public String demo2(){
        return "chenggong!";
    }
}
