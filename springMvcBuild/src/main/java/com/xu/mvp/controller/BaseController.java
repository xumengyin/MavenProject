package com.xu.mvp.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView view =new ModelAndView();
        doProcess(view,request,response);
        return view;
    }
    public abstract void doProcess(ModelAndView modelAndView,HttpServletRequest request, HttpServletResponse response);
}
