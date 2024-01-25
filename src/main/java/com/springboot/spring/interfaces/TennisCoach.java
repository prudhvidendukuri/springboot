package com.springboot.spring.interfaces;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("IN Constructor = Tennis");
    }

    @Override
    public String getWorkout() {
        return "Tennis Coach";
    }
}
