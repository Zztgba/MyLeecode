package com.thread;

import java.util.concurrent.*;

public class ThreadPool01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> c = (Future<Object>) executorService.submit(new Runnable(){
            @Override
            public void run() {
                System.out.println("this is my thread-pool submit");
            }
        });
        System.out.println(c.get());
        System.out.println(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is my thread-pool execute");
            }
        });
    }
}
