package com.xu.spring;

import com.xu.mybatis.util.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * 接入构造bean 回调方法
 */
public class MyBeanPostProcessorLow implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Log.d("Low postProcessAfterInitialization:"+beanName+"---"+bean.getClass().getSimpleName());
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Log.d("Low postProcessBeforeInitialization:"+beanName+"---"+bean.getClass().getSimpleName());
        return bean;
    }

    /**
     * 值越小 优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 1000;
    }
}
