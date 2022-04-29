package com.pocket.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")//hello.html에서 get요청이 왔을경우
    public String hello(Model model){
        model.addAttribute("data", "hello~~~~");
        return "hello";//hello.html에 보냄
    }
}
