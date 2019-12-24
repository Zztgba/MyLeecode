package com.callback;

/**
 * @Author zhongzaitao
 * @Date 2019-9-19 21:31
 */
public class Caller {
    private SmsInterface smsInterface;
    Caller(SmsInterface s){
        smsInterface=s;
    }
    void call(){
        smsInterface.callback();
    }
}
