package com.springboot.spring.interfaces;


import org.springframework.context.annotation.Configuration;


public class CustomBean implements Coach{

    @Override
    public String getWorkout() {
        return "Custom Bean";
    }

    public CustomBean() {
        System.out.println("IN Constructor - custom Bean");
    }
}
