package com.callback;

/**
 * @Author zhongzaitao
 * @Date 2019-9-19 21:32
 */
public class T {
    public static void main(String[] args) {
        Callback callback = new Callback();
        callback.callback();
        System.out.println("-------------");
        Caller c = new Caller(callback.getSmsInterface());
        c.call();
    }
}
