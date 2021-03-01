package com.xu.serveLet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestCookieServet extends BaseHttpServlet{
    @Override
    public void todo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().println("cookieName:"+cookie.getName()+"--cookie Value:"+cookie.getValue());
        }
        Cookie cookie= new Cookie("usedName","嘘嘘");
        Cookie cookie2= new Cookie("currentTime",System.currentTimeMillis()+"");
        resp.addCookie(cookie);
        resp.addCookie(cookie2);

    }
}
