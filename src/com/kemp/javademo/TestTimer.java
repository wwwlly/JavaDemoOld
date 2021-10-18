package com.kemp.javademo;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    public static void main(String[] args){

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            int i = 0;

            @Override
            public void run() {
                if(i == 5){
                    timer.cancel();
                    return;
                }
                System.out.println("task current: " + System.currentTimeMillis());
                System.out.println("task name: " + Thread.currentThread().getName());
                System.out.println("do tasts.");
                i ++;
            }
        };
//        timer.schedule(timerTask, 5 * 1000);
        timer.schedule(timerTask, 1000, 1000);
        System.out.println("main current: " + System.currentTimeMillis());
        System.out.println("main name: " + Thread.currentThread().getName());
    }


}


