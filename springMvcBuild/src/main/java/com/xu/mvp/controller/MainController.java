package com.xu.mvp.controller;


import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller 方式一  集成Controller接口
 */
public class MainController extends BaseController {
    @Override
    public void doProcess(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
//        modelAndView.
        modelAndView.addObject("msg","fuck");
    }
}
