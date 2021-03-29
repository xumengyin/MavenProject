package com.xu.pojo;

import com.xu.util.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("video")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Video implements Serializable,ApplicationContextAware {

    @Value("2")
    public String id;
    @Value("Tanzend")
    public String name;
    @Value("xuxu")
    public String author;
    @Value("100")
    public String goal;
    @Autowired
    @Qualifier("company")
    public Company company;
    public Video() {
    }

    public Video(String id, String name, String author, String goal,Company company) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.goal = goal;
        this.company = company;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", goal='" + goal + '\'' +
                ", company=" + company +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Log.d("Video setApplicationContext -"+this.toString());
    }
}
