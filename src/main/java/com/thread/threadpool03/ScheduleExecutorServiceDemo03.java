package com.thread.threadpool03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 *  测试ScheduleExecutorService接口中延迟执行任务和重复执行任务的功能
 */
public class ScheduleExecutorServiceDemo03 {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor( new ThreadFactory() {
            int n = 1000;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义单线程名："+n++);
            }
        });
        es.scheduleWithFixedDelay(new MyRunnable03(100),1,2,TimeUnit.SECONDS);
        System.out.println("over");

    }
}

class MyRunnable03 implements Runnable{

    private int id;

    public MyRunnable03(int id ){
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name +"执行了任务："+id+";当前时间："+System.currentTimeMillis());
    }
}
