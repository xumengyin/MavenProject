package com.xu.spring;

import com.xu.pojo.Boss;
import com.xu.pojo.Player;
import com.xu.pojo.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration //配置注解
@Lazy
@ComponentScan("com.xu.pojo") //扫描包
public class SpringConfiguration {

    @Bean
    public Video getP()
    {
        return new Video();
        //return new Video();
    }
    @Bean
    public Boss getBoss()
    {
        return new Boss("11","11");
        //return new Video();
    }
}
