package com.xu.pojo;

import com.xu.mybatis.util.Log;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

public class Video implements Serializable,Init,Destroy, ApplicationContextAware {

    public String id;
    public String name;
    public String author;
    public String goal;

    public Video() {
    }

    public Video(String id, String name, String author, String goal) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", goal='" + goal + '\'' +
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
    public void init() {
        Log.d("Video class init -"+this.toString());
    }

    @Override
    public void destroy() {
        Log.d("Video destroy -"+this.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Log.d("Video setApplicationContext -"+this.toString());
    }
}
