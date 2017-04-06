package com.plz.bean;

import com.plz.ioc.annotations.Bean;

/**
 * Created by andy on 17-4-6.
 */
@Bean
public class User {
    private String name;
    private int age;

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
}
