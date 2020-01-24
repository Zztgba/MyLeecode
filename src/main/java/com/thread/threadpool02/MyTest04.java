package com.thread.threadpool02;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/*
    练习Executor 获取ExecutorService，然后调用方法，提交任务
 */
public class MyTest04 {
    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=1; i<=10; i++){
            executorService.submit(new MyRunable04(i));
        }
        //关闭线程池，仅关闭，已提交的任务仍执行
        executorService.shutdown();
        executorService.submit(new MyRunable04(88));
    }

    private static void test2(){

        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n = 1;

            @Override
            public String toString() {
                return "$classname{" +
                        "n=" + n +
                        '}';
            }

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称:"+n++);
            }
        });
        for (int i=1; i<=10; i++){
            executorService.submit(new MyRunable04(i));
        }
        //3:立刻关闭，如果缓存中任务未完成，直接返回
        List<Runnable> list = executorService.shutdownNow();
        System.out.println(list);
    }
}

class MyRunable04 implements Runnable{

    private int id;

    public MyRunable04(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyRunable04{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+ "执行了任务。。。id:"+id);
    }
}
