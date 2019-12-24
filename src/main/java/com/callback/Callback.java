package com.callback;

/**
 * @Author zhongzaitao
 * @Date 2019-9-19 21:27
 */
public class Callback extends CallbackSmsInterface {
    @Override
    public void callback() {
        super.callback();
        System.out.println("子业务逻辑");
    }

    private class Callback1 implements SmsInterface{

        @Override
        public void callback() {
            Callback.this.callback();
        }
    }

    SmsInterface getSmsInterface(){
        return new Callback1();
    }
}
