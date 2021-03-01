package com.xu.mybatis.intercepter;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Statement;
import java.util.Properties;


@Intercepts(@Signature(type= ResultSetHandler.class,method = "handleResultSets",args = {Statement.class}))
public class ResultMapInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("ResultMapInterceptor before");
        Object returnObject = invocation.proceed();

        System.out.println("ResultMapInterceptor after");
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
