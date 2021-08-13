package com.saran.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.swing.*;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulingApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SpringSchedulingApplication.class, args);
        scheduledFixedRateTask();
        scheduledFixedDelayTask();

        SpringSchedulingApplication application = new SpringSchedulingApplication();
        application.scheduleFixedRateTaskAsync();

    }

    //fixedDelay property makes sure that there is a delay of n millsec between the finish time
    // of an exection of a task and the start time of the next exection of the task.
    @Scheduled(fixedDelay = 1000)
    public static void scheduledFixedDelayTask(){
        System.out.println("Fixed Delay Task - "+ System.currentTimeMillis() / 1000 );
    }

    //fixedRate property runes the scheduled task at evey n millisecond - no matter when the tasks ends.
    @Scheduled(fixedRate = 1000)
    public static void scheduledFixedRateTask(){
        System.out.println(" Fixed Rate Task - "+ System.currentTimeMillis() / 1000);
    }

    // Async job
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException{
        System.out.println(
                "Fixed rate task async -" + System.currentTimeMillis() / 1000
        );
        Thread.sleep(2000);
    }

    // with inital delay
    @Scheduled(fixedDelay = 2000, initialDelay = 1000)
    public static void scheduledFixedDelayWithInitialDelay(){
        long now = System.currentTimeMillis() / 1000 ;
        System.out.println(" Fixed Delay with Initial delay - "+ now);
    }

    //Scheduled Task with Cron expression
    @Scheduled(cron = "0 15 10 15 * ?")  //Executed at 10:15 AM on the 15the day of every month
    public static void scheduledTaskWithCronExpression(){
        long now = System.currentTimeMillis() / 1000;

    }

}
