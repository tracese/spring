package com.trace.springbootquick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author PC
 * @date 2020/5/21
 */

@Controller
@ResponseBody

public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World Quick";
    }
}
