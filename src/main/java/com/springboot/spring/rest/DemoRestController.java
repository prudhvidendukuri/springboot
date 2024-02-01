package com.springboot.spring.rest;

import com.springboot.spring.entity.ErrorMessage;
import com.springboot.spring.entity.User;
import com.springboot.spring.exceptions.CustomException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    private List<User> theUsers;

    @PostConstruct
    public void anyMethodName(){
        theUsers = new ArrayList<User>();
        theUsers.add(new User("prudhvi","admin"));
        theUsers.add(new User("rama","user"));
        theUsers.add(new User("raju","user"));
    }
    @GetMapping("/get/{pathvariable}")
    public User getUser(@PathVariable int pathvariable){

        if((pathvariable > theUsers.size()) || pathvariable <0){
            throw new CustomException("custom message matter");
        }
        return theUsers.get(pathvariable);
    }
//Moving all the Exceptions into GlobalException instead of writing in the same controller
//For Small projects custom exceptions can be written in the same controller

//    @ExceptionHandler
//    public ResponseEntity<ErrorMessage> errorHandler(CustomException exc){
//        ErrorMessage error = new ErrorMessage();
//        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @ExceptionHandler
//    public ResponseEntity<ErrorMessage> errorHandlerForAnyException(Exception exc){
//        ErrorMessage error = new ErrorMessage();
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
}
