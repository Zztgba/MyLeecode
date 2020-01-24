package com.thread.threadpool;


/*
    测试类：
        1、创建线程池类
        2、提交多个任务

 */
public class MyThreadPoolTest {

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(2,4,20);

        //提交多个任务
        for (int i = 0; i<40; i++){
            //创建任务对象，并提交至线程池
            MyTask myTask = new MyTask(i);
            pool.sumbit(myTask);
        }
    }

}
