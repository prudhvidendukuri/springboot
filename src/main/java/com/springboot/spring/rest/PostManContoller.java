package com.springboot.spring.rest;

import com.springboot.spring.entity.User;
import com.springboot.spring.exceptions.CustomException;
import org.springframework.http.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpRequest;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/postman")
public class PostManContoller {
    public PostManContoller(){
        System.out.println("POSTMAN CONTROLLER - BEAN - Constructor");
    }

    @PostMapping("/post")
    public ResponseEntity<String> getRequest(RequestEntity<String> request){
        String body = request.getBody();
        HttpHeaders headers = request.getHeaders();
        System.out.println(body);
        System.out.println(headers);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/otp/{mobileNumber}")
    public ResponseEntity<String> sendOtp(@PathVariable String mobileNumber){
//        String uri = "http://localhost:8123/api/postman/post";
        //validate mobilenumber
        if(mobileNumber.length() == 10){
            //convert it into number
            //create a OTP
            int OTP = (int) Math.floor(Math.random()*1000000);

            //add them to uri
            String uri = "https://api.authkey.io/request?authkey=45169b91ac51668e&mobile="+mobileNumber+"&country_code=91&sid=11851&company=Nerdpine&otp="+OTP+"";

    //        request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
    //                .header("key","value")
    //                .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
    //        response
            CompletableFuture<String> responseFuture= client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body);
            String responseMessage = responseFuture.join();
            System.out.println(responseMessage);

            return new ResponseEntity<>(responseMessage,HttpStatus.OK);
        }else{
            throw new CustomException("Enter correct 10 digits");
        }




    }
}
