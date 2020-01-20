package com.thread.threadpool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 自定义的线程池类
 *
 * 成员变量：
 *      1：任务队列  集合      需要控制线程安全问题
 *      2：当前线程数量
 *      3：核心线程数量
 *      4：最大线程数量
 *      5：任务队列的长度
 *
 * 成员方法
 *      1：提交任务；
 *          将任务添加到集合中，需要判读是否超出了任务长度
 *      2：执行任务；
 *          判断当前线程的数量，决定创建核心线程还是非核心线程
 */
public class MyThreadPool {

    //1任务队列
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
    //2当前线程数量
    private int num;
    //3核心线程数量
    private int corePoolSize;
    //4最大线程数量
    private int maxSize;
    //5任务队列长度
    private int queueSize;


    //提交任务
    public void sumbit(Runnable r){
        //任务队列是否已满
        if (tasks.size() >= queueSize){
            System.out.println("任务队列已满："+r);
        }else {
            tasks.add(r);
            execute(r);
        }
    }


    //执行任务
    private void execute(Runnable r){
        //判断线程量，是否超出核心线程数
        if (num < corePoolSize){

        }
    }

}
