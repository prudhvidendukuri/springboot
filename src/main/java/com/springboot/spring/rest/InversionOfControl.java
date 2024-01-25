package com.springboot.spring.rest;

import com.springboot.spring.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import outsidepackagescan.OutsideClassRead;

//lazy initilization - only when this end point hits then it loads
@RestController
@Lazy
public class InversionOfControl {

    //constructor injection
//    Coach myCoach = new Coach();
//    InversionOfControl newIOC = new InversionOfControl(mycoach);
//
//    private Coach myCoach;
//
//    @Autowired
//    public InversionOfControl(Coach coach){
//        myCoach = coach;
//    }

    //setter injection
//    Coach myCoach = new Coach();
//    InversionOfControl newIOC = new InversionOfControl();
//    newIOC.setMethod(myCoach)

    private Coach myCoach;

    private Coach anotherCoach;

    @Autowired
    public void setMethod(
            @Qualifier("basketBallCoach") Coach coach,
            @Qualifier("basketBallCoach") Coach anotherCoach

    ){
        System.out.println("In constructor = IOC");
        this.myCoach = coach;
        this.anotherCoach = anotherCoach;
    }

    //for primary qualifier - Cricket Coach - no need give qualifier annotation
//    @Autowired
//    public void setMethods(Coach coach){
//        this.myCoach = coach;
//    }

    //field injection - which is available in legacy/old projects
//    @Autowired
//    private Coach myCoach;
    //not recommended - because it is harder to unit test

    @Autowired
    private OutsideClassRead outsideClassRead;

    @GetMapping("/getworkout")
    public String getworkoutcontroller(){

        return myCoach.getWorkout()+" - " + outsideClassRead.fromotherclass ;
    }
    @GetMapping("/check")
    public String getBeanScope(){
        return "Bean Scope Type - "+ (myCoach == anotherCoach);
    }

}
