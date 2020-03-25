package com.xl.springbootdemo1.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ScheduledService {

    //秒  分 时 日 月 星期
    @Scheduled(cron = "0/10 * * * * ?")
    public void hello(){
        System.out.println("你被执行了"  );
    }

}
