package com.test.inteface.buttonmain;

import com.test.inteface.Button;

/**
 * @Author zhongzaitao
 * @Date 2019-9-11 21:02
 */
public class CallBack {

    static class MyClickListener implements Button.OnClickListener{

        @Override
        public void click() {
            System.out.println("MyClickListener点击按钮");
        }
    }

    static class MyLongClickListener implements Button.OnLongClickListener{

        @Override
        public void longClick() {
            System.out.println("MyLongClickListener长按了");
        }
    }

    public static void main(String[] args) {
        MyClickListener click = new MyClickListener();
        MyLongClickListener longClick = new MyLongClickListener();
        Button button = new Button();
        button.setOnClickListener(click);
        button.setOnLongClickListener(longClick);
        button.mockClick();
        button.mockLongClick();
    }
}
