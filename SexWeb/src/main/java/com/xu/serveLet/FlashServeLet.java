package com.xu.serveLet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * 测试刷新
 */
public class FlashServeLet extends BaseHttpServlet{
    @Override
    public void todo(HttpServletRequest req, HttpServletResponse resp) {

        //解决中文乱码
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("refresh","3");
        String data = new Random(100000).nextInt()+"";
        try {
            resp.getWriter().print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
