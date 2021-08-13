package com.saran.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulingApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringSchedulingApplication.class, args);
        scheduledFixedRateTask();
        scheduledFixedDelayTask();
    }

    @Scheduled(fixedDelay = 1000)
    public static void scheduledFixedDelayTask(){
        System.out.println("Fixed Delay Task: "+ System.currentTimeMillis() / 1000 );
    }

    @Scheduled(fixedRate = 1000)
    public static void scheduledFixedRateTask(){
        System.out.println(" Fixed Rate Task"+ System.currentTimeMillis() / 1000);
    }

}
