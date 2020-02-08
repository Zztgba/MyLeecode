package com.thread.threadpool06;

public class MyTask implements Runnable {

    private static int price=1000;
    private int change;
    private String userName;

    public MyTask(String userName ,int change){
        this.change = change;
        this.userName = userName;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(userName+"正在准备使用"+name+"取款："+change+"元");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (MyTask.class){
            if (change<=price){
                price-=change;
                System.out.println(userName+"使用"+name+"  取出："+change+"元，余额："+price+"元  执行成功--");
            }else {
                System.out.println(userName+"使用"+name+"  取款："+change+"元失败！");
            }
        }
    }
}
