package com.springboot.spring.interfaces;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//giving a scope to prototype makes this component - lazy by default
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BasketBallCoach implements Coach{
    @Override
    public String getWorkout() {
        return "basketBallCoach";
    }

    public BasketBallCoach(){
        System.out.println("IN Constructor = BasketBall");
    }
}
