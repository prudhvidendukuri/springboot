package com.springboot.spring.exceptions;

import com.springboot.spring.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//            this is a global Exception Handler which is a real time example of
//            AOP where all the requests are interfered by this advice controller
//            so when exception is occered instead of writting in @ExceptionHandler here
//            we can write all the exceptions

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> errorHandler(CustomException exc){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> errorHandlerForAnyException(Exception exc){
        ErrorMessage error = new ErrorMessage();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
