package com.xl.springbootdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@MapperScan("com.xl.springbootdemo1.Mapper")
public class SpringbootDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1Application.class, args);
    }

}
