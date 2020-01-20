package com.thread;

import com.test.T;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MyThead {

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread01();
        t1.run();
        t1.start();
        System.out.println("main:{}"+t1.getId());

        Runnable runnable = new Runnable01();
        runnable.run();
        Thread t2 = new Thread(runnable);
        t2.start();
        System.out.println("main:{}"+t2.getId());

        FutureTask task = new FutureTask(new Callable01());
        Thread t3 = new Thread(task);
        t3.start();
        System.out.println("main:{}"+new Callable01().call());
        System.out.println("main:{}"+task.get());
        System.out.println("main:{}"+t3.getId());
    }

    /**
     * 单线程
     * @throws Exception
     */
    @Test
    public void treadsPKthread() throws Exception{
        long start = System.currentTimeMillis();
        final List<Integer> l = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i<10000; i++){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }
        System.out.println();
        System.out.println("时间："+(System.currentTimeMillis()-start));
        System.out.println("size:"+l.size());
    }

    @Test
    public void treads() throws Exception{
        long start = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Random random = new Random();
        for (int i=0; i<10000; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.DAYS);
        System.out.println("时间："+ (System.currentTimeMillis()-start));
        System.out.println("size:"+list.size());
    }

}
class Thread01 extends Thread{

    @Override
    public void run(){
        System.out.println("this is my thread"+this.getId());
    }
}

class Runnable01 implements Runnable{

    @Override
    public void run() {
        System.out.println("this is my runable");
    }
}

class Callable01 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("this is my callable");
        return "my call";
    }
}


