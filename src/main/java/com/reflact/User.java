package com.reflact;

import jdk.internal.org.objectweb.asm.commons.Method;

/**
 * @Author zhongzaitao
 * @Date 2019-9-27 14:35
 */
public class User {
    private int id;
    public String name;
    public String password;

    public User(){    }
    private User(int id){}
    public User(String name){
        this.name = name;
    }
    public User(String name,String password){}
    private User(int id,String name,String password){}

    public void publicmehtod1() throws Exception {
        System.out.println(Method.getMethod(User.class.getMethod("publicmehtod1"))+"******");
    }
    public String publicmehtod2(String i ){
        System.out.println("public method 2_______________"+i);
        return "this is public mehtod2";
    }
    private void privatemethod1(){
        System.out.println("privatemethod1--------------");
    }

    private void privatemethod2(String i){
        System.out.println("privatemethod1------------！！！——"+i);
    }
    void method3(){
        System.out.println("method3");
    }
    protected void method4(){
        System.out.println("mehtod4");
    }

    public static void main(String[] args) {
        System.out.println("这是 User 类的 main 方法"+args.length);
    }
}
