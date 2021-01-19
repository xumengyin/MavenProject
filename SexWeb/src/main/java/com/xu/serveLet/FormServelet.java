package com.xu.serveLet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试提交表单
 */
public class FormServelet extends BaseHttpServlet{
    @Override
    public void todo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name =req.getParameter("name");
        String password =req.getParameter("password");
        req.getRequestDispatcher("/root").forward(req,resp);
    }
}
