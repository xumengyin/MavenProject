package com.xu.pojo;

import java.io.Serializable;

public class Boss implements Serializable {
    public String id;
    public String name;

    public Boss(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
