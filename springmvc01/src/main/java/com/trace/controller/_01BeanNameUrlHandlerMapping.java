package com.trace.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 沈泽群
 * @date 2020/7/12
 */
public class _01BeanNameUrlHandlerMapping implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("这句话有没有执行"+httpServletRequest.getRequestURL());
        return null;
    }
}
