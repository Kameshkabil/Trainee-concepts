package com.example.dtoslearning.schedulerImplementation;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    @Scheduled(cron = "0 * 18 * * ?")
    public void cronJobsch()throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = simpleDateFormat.format(now);
        System.out.println("Java cron job expression:: "+strDate);
    }
}
