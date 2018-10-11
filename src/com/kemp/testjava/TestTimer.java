package com.kemp.testjava;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    public static void main(String[] args){

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("current: " + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName());
                System.out.println("do tasts.");
                timer.cancel();
            }
        };
        timer.schedule(timerTask, 5 * 1000);
        System.out.println("current: " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
    }


}


