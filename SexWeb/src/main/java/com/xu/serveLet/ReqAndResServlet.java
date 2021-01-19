package com.xu.serveLet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;

public class ReqAndResServlet  extends BaseHttpServlet {


    /**
     * 下载图片和路径地址
     * @param req
     * @param resp
     */
    @Override
    public void todo(HttpServletRequest req, HttpServletResponse resp) {

        try{
            String filename ="img2.jpeg";
            //下载图片文件
            resp.setContentType("image/jpg");
            resp.addHeader("Content-Disposition", "attachment;filename=" + filename);

            String path=req.getContextPath()+"/"+filename;
            //System.out.printf("getContextPath:"+req.getContextPath()+"getServletContext:"+getServletContext().getre);

            //getClass().getResourceAsStream 和getServletContext().getResourceAsStream() 路径不一样
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filename);
           // InputStream resourceAsStream = getServletContext().getResourceAsStream("/res/"+filename);
//            URL resource = getClass().getResource(filename);
//            System.out.println(resource.toString());
            byte[] buffer =new byte[1024];
            ServletOutputStream outputStream = resp.getOutputStream();
            int length=0;
            while ((length=resourceAsStream.read(buffer))>-1)
            {
                outputStream.write(buffer,0,length);
            }
            outputStream.close();
            resourceAsStream.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
