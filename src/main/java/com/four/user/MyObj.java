package com.four.user;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class MyObj {

     public void my(){
         System.out.println("my");
     }

    public MyObj() {

        System.out.println("对象" + this + "创建");

    }

     

    /**

     * 重写finalize方法，在对象被gc的时候打印日志

     * @throws Throwable

     */

    @Override

    protected void finalize() throws Throwable {

        super.finalize();

        System.out.println(this + " is gc");

    }

    /**
     * 强引用，及时堆满也不会被回收，将报错OutOfMemoryError终止程序
     */
    @Test
    public void test01() {

        MyObj obj = new MyObj();

        // new一个20M的byte数组，使堆空间不足，进而触发gc

        byte[] bytes = new byte[1024 * 1024 * 20];

    }

    /**
     * 与test01对比，当堆中数据不再被任何指向，可以清理
     *
     * 即：将强引用置为null后，gc的时候才会被回收。
     */
    @Test
    public void test02() {

        MyObj obj = new MyObj();
        MyObj obj2 = new MyObj();
        obj = null;
        obj2 = null;
        // new一个20M的byte数组，使堆空间不足，进而触发gc

        byte[] bytes = new byte[1024 * 1024 * 20];

    }

    @Test
    public void test03() {

        WeakReference<MyObj> weakReference = new WeakReference<MyObj>(new MyObj());

        System.out.println("堆空间充足的时候主动触发gc");

        System.gc();


    }


}