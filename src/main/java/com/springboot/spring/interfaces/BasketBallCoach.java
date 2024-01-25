package com.springboot.spring.interfaces;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{
    @Override
    public String getWorkout() {
        return "basketBallCoach";
    }

    public BasketBallCoach(){
        System.out.println("IN Constructor = BasketBall");
    }
}
