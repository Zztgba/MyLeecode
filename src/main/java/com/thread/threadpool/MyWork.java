package com.thread.threadpool;

import java.util.List;

/*
    需求：
        便携一个线程类，需要继承Thread类，设计一个属性，用于保存线程的名字
        设计一个集合，用于保存所有的任务；
 */
public class MyWork extends Thread{

    private String name;//保存线程的名字
    private List<Runnable> tasks; //任务列

    public MyWork(String name, List<Runnable> tasks){
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        //判断集合集合中是否有任务，只要有就不断执行
        while (tasks.size()>0){
            Runnable r = tasks.remove(0);
            r.run();
        }
    }
}
