package com.thread.threadpool;


/*
    需求：
        自定义线程池联系。任务类，需要实现Runnable;
        包含任务编号，每一个任务执行时间设计为0.2秒;
 */
public class MyTask  implements Runnable{

    private int id;

    MyTask(int id){
        this.id = id;
    }

    @Override
    public void run() {

        System.out.println("线程："+Thread.currentThread().getName()
                +", 即将执行任务id为： "+id);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程："+Thread.currentThread().getName()+"完成了任务");
    }
}
