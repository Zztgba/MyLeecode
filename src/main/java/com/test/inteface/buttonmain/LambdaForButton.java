package com.test.inteface.buttonmain;

import com.test.inteface.Button;

/**
 * @Author zhongzaitao
 * @Date 2019-9-11 21:16
 */
public class LambdaForButton {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(() -> System.out.println("lambda onclick"));
        button.setOnLongClickListener(() -> System.out.println("lambda onlongclick"));

        button.mockClick();
        button.mockLongClick();
    }

    public static void t(String s){
        System.out.println(s);
    }
}
