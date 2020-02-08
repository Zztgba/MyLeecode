package com.thread.threadpool04;

import java.util.concurrent.*;

/**
 *   练习异步计算结果
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> future = es.submit(new MyCall(1,1));
//        test1(future);
        future.cancel(true);
        System.out.println("第一次判断任务是否取消："+future.isCancelled());
        int v =  future.get();
//        int v =  future.get(1,TimeUnit.SECONDS);
        System.out.println("任务执行结果为："+v);

    }

    //正常测试流程
    private static void test1(Future<Integer> future) throws InterruptedException, ExecutionException {
        //判断任务是否已经完成
        System.out.println("第一次判断任务是否完成："+future.isDone());
        System.out.println("第一次判断任务是否取消："+future.isCancelled());
        int v = future.get();//一直等待任务执行，直到完成
        System.out.println("任务执行结果为："+v);
        System.out.println("第二次判断任务是否完成："+future.isDone());
        System.out.println("第二次判断任务是否取消："+future.isCancelled());
    }
}

class MyCall implements Callable<Integer>{

    private int a;
    private int b;

    public MyCall(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name + " 准备开始计算...");
        Thread.sleep(2000);
        System.out.println(name + " 计算结束...");
        return a+b;
    }
}
