package com.xu.mybatis.intercepter;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;


@Intercepts(@Signature(type= Executor.class,method = "query",args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}))
public class SqlInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("SqlInterceptor before");
        Object returnObject = invocation.proceed();

        System.out.println("SqlInterceptor after");
        return returnObject;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String sqlP = properties.getProperty("sqlP");
        System.out.println("SqlInterceptor sqlP:"+sqlP);
    }
}
