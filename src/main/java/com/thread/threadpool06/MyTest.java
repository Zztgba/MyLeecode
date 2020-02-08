package com.thread.threadpool06;

import java.util.concurrent.*;

public class MyTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3, new ThreadFactory() {
            int id = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"ATM"+id++);
            }
        });

//        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,2,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>(3));
        for (int i=1; i<=3; i++){
            MyTask myTask = new MyTask("客户"+i,800);
            pool.submit(myTask);
        }
        pool.shutdown();
    }
}
