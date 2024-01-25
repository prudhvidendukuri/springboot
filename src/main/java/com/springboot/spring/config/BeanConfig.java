package com.springboot.spring.config;

import com.springboot.spring.interfaces.CustomBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    //without -ID
//    @Bean
//    public CustomBean customBeanID(){
//        return new CustomBean();
//    }
    @Bean("customIDForBean")
    public CustomBean customBeanID(){
        return new CustomBean();
    }
}
