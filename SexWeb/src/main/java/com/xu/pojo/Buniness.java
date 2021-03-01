package com.xu.pojo;

import com.xu.mybatis.util.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

public class Buniness implements Serializable,Init,Destroy, ApplicationContextAware , BeanNameAware {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void destroy() {
        Log.d("Buniness:destroy");
    }

    @Override
    public void init() {
        Log.d("Buniness:init");
    }

    /**
     *
     *spring容器 回调提供给你的context
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Log.d("Buniness:setApplicationContext"+applicationContext);
    }

    @Override
    public void setBeanName(String s) {
        Log.d("Buniness:setBeanName:"+s);
    }
}
