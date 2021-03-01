package com.xu.pojo;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable,Init,Destroy {

    private int id;
    private String name;
    private int age;
    private String sex;
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", videos=" + videos +
                '}';
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }
}
