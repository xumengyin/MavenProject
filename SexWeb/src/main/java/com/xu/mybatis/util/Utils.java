package com.xu.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        return sqlSessionFactory.openSession(true);
    }

    public static void close(SqlSession session)
    {
        if (session!=null) {
            session.close();
        }
    }
}
