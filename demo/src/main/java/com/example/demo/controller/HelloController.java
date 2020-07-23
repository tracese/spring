package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody*/
@RestController
public class HelloController {
    @Value("${person.last-name}")
    String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello "+name;
    }
}
