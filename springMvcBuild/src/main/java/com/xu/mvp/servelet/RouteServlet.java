package com.xu.mvp.servelet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RouteServlet  extends BaseServlet{
    @Override
    protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
