package com.springboot.spring.rest;

import com.springboot.spring.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanScope {

    private Coach coach;

    //Normal bean from component
//    @Autowired
//    public void setBeanScope(@Qualifier("beanCoach") Coach coach){
//        System.out.println("in setMethod injection - Bean Scope");
//        this.coach = coach;
//    }
    //Bean from configuration annotation
//    @Autowired
//    public void setBeanScope(@Qualifier("customBeanID") Coach coach){
//        System.out.println("in setMethod injection - Bean Scope");
//        this.coach = coach;
//    }
    //bean with custom ID
    @Autowired
    public void setBeanScope(@Qualifier("customIDForBean") Coach coach){
        System.out.println("in setMethod injection - Bean Scope");
        this.coach = coach;
    }
    @GetMapping("/beanScope")
    public String getBeanScope(){
        return coach.getWorkout();
    }

    public BeanScope() {
        System.out.println("in constructor - Bean Scope");
    }
}
