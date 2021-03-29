package com.xu.mvp.servelet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        doRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        doRequest(req, resp);
    }

   protected abstract void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
