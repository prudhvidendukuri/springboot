package com.springboot.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class FunRestController {
    //injecting prop values from application.properties
    @Value("${custom.value}")
    public String custom;

    public FunRestController() {
        System.out.println("IN Constructor = Fun REst Controller");

    }

    //@GetMapping("/") -- default is value
    @GetMapping(value = "/")
    public String helloWorld(){
        return custom + "Working";
    }
}
