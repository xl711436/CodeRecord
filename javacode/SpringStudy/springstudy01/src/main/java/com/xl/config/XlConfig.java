package com.xl.config;

import com.xl.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XlConfig {

    @Bean
    public User getUser1(){
        return new User();
    }
}
