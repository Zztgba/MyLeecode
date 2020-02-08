package com.thread.threadpool05;

/**
 *  任务类
 *      包含了商品数量
 */
public class MyTask implements Runnable {

    private static int id = 10;
    private String username;

    public MyTask(String userName){
        this.username = userName;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(username+"正在使用"+name+"参与秒杀任务...");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (MyTask.class){
            if (id >0){
                System.out.println(username+"使用"+name+"秒杀："+id--+"秒杀成功---");
            }else {
                System.out.println(username+"使用"+name+"秒杀失败了！");
            }
        }
    }
}
