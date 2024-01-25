package com.springboot.spring.interfaces;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("IN Constructor = CricketCoach");
    }

    @Override
    public String getWorkout() {
        return "Do 20 pushups";
    }
}
