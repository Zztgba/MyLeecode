package com.four.user.test;

import com.four.user.MyObj;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @Author zhongzaitao
 * @Date 2019-9-26 17:07
 */
public class UsingTest {

    public static void main(String[] args) {

        MyObj obj = new MyObj();
        MyObj obj2 = new MyObj();
        obj = new MyObj();
        obj2 = new MyObj();
        // new一个20M的byte数组，使堆空间不足，进而触发gc

        byte[] bytes = new byte[1024 * 1024 * 8];
        bytes = null;
        obj = new MyObj();
        obj2 = new MyObj();
        byte[] bytes1 = new byte[1024 * 1024 * 8];
        byte[] bytes2 = new byte[1024 * 1024 * 8];

    }


    /**
     * 在堆空间充足的时候，jvm不会回收软引用对象，软引用对象只有在堆空间不足的时候才会被回收
     */
    @Test

    public void test03() {

        ReferenceQueue<MyObj> queue = new ReferenceQueue();

        MyObj obj = new MyObj();

        SoftReference<MyObj> softReference = new SoftReference<MyObj>(new MyObj());

        System.out.println("堆空间充足的时候主动触发gc");
        System.gc();
        System.out.println("new一个20M的byte数组，使堆空间不足，进而触发gc");

        byte[] bytes1 = new byte[1024 * 1024 * 40];

    }



}
