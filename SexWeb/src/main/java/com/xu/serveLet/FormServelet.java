package com.xu.serveLet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * 测试提交表单
 */
public class FormServelet extends BaseHttpServlet{
    @Override
    public void todo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name =req.getParameter("name");
        String password =req.getParameter("password");

        Collection<Part> parts = req.getParts();
        Enumeration<String> attributeNames = req.getAttributeNames();
        getMultipartData(req,resp);
        resp.getWriter().println("name:"+name);
        resp.getWriter().println("password:"+password);
       // req.getRequestDispatcher("/root").forward(req,resp);
    }

    private void getMultipartData(HttpServletRequest request,HttpServletResponse resp)
    {
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload sUpload=new ServletFileUpload(factory);

        try {
            List<FileItem> list=sUpload.parseRequest(request);
            for (FileItem fileItem : list) {
                resp.getWriter().println("mult name:"+fileItem.getName()+"---value:"+fileItem.getString());
                resp.getWriter().println("mult all:"+fileItem.toString());
            }

           // System.out.printf(""+list.toString());
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        }

    }
}
