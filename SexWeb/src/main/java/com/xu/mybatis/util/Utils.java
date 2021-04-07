package com.xu.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static SqlSessionFactory sqlSessionFactory;


    static {
        String res="mybatis-config.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(res);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return getSession(true);
    }
    public static SqlSession getSession(boolean auto) {
        return sqlSessionFactory.openSession(auto);
    }

    public static void close(SqlSession session)
    {
        if (session!=null) {
            session.close();
        }
    }
    public static ClassPathXmlApplicationContext getSpringContext(String path) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        return context;
    }
}
