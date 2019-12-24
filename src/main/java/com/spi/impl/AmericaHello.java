package com.spi.impl;

import com.spi.Hello;

/**
 * @Author zhongzaitao
 * @Date 2019-11-2 11:27
 */
public class AmericaHello implements Hello {
    @Override
    public void sayHello() {
        System.out.println("American people say , hello");
    }
}
