package com.thread.threadpool02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
    练习Executor 获取ExecutorService，然后调用方法，提交任务
 */
public class MyTest03 {
    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=1; i<=10; i++){
            executorService.submit(new MyRunable03(i));
        }
    }

    private static void test2(){

        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称:"+n++);
            }
        });
        for (int i=1; i<=10; i++){
            executorService.submit(new MyRunable03(i));
        }
    }
}

class MyRunable03 implements Runnable{

    private int id;

    public MyRunable03(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+ "执行了任务。。。id:"+id);
    }
}
