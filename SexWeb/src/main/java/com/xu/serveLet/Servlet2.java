package com.xu.serveLet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRes(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRes(req, resp);
    }

    private void doRes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       // resp.getWriter().append("<")

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>fuck </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>serverLet222222</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
