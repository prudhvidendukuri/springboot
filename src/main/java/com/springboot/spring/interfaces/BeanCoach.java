package com.springboot.spring.interfaces;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//to make a bean
@Component

public class BeanCoach implements Coach{
    @Override
    public String getWorkout() {
        return "Bean Coach ";
    }

    public BeanCoach() {
        System.out.println("Constructor + Bean");
    }

    @PostConstruct
    public void doStartUpSteps(){
        System.out.println("Bean Start Up- init");
    }
    @PreDestroy
    public void doCleanUpSteps(){
        System.out.println("Bean Clean Up- destroy");
    }
}
