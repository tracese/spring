package com.trace.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 沈泽群
 * @date 2020/7/11
 */
@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String hello(){
        return "success";
    }
}
