package com.thread.threadpool05;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>(15));
        for (int i=1; i<=20; i++){
            MyTask myTask = new MyTask("客户"+i);
            pool.submit(myTask);
        }
        pool.shutdown();
    }
}
