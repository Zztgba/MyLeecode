package com.spi.impl;

import com.spi.Hello;

/**
 * @Author zhongzaitao
 * @Date 2019-11-2 11:25
 */
public class ChinaHello implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Chinese people say , 你好");
    }
}
