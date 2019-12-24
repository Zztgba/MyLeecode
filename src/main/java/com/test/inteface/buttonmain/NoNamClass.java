package com.test.inteface.buttonmain;

import com.test.inteface.Button;

/**
 * @Author zhongzaitao
 * @Date 2019-9-11 21:13
 */
public class NoNamClass {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public void longClick() {
                System.out.println("NoNamClass长按操作");
            }
        });

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void click() {
                System.out.println("NoNamClass点击按钮");
            }
        });

        button.mockLongClick();
        button.mockClick();
    }
}
