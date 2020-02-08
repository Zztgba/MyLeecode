package com.thread.threadpool03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *  测试ScheduleExecutorService接口中延迟执行任务和重复执行任务的功能
 */
public class ScheduleExecutorServiceDemo01 {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);

        for (int i=1; i<=10; i++){
            es.schedule(new MyRunnable(i),2, TimeUnit.SECONDS);
        }
        System.out.println("over");

    }
}

class MyRunnable implements Runnable{

    private int id;

    public MyRunnable(int id ){
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name +"执行了任务："+id+";当前时间："+System.currentTimeMillis());
    }
}
