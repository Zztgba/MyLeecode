package com.reflact;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author zhongzaitao
 * @Date 2019-9-27 14:39
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class a = Class.forName("com.reflact.User");

            System.out.println("类名");
            System.out.println(a.getName());
            System.out.println("------------------------");

            System.out.println("getConstructors()方法获取类加载器：");
            Constructor[] con = a.getConstructors();
            for (Constructor c : con){
                System.out.println(c);
            }
            System.out.println("------------------------");

            System.out.println("..Declared..()方法获取类加载器：");
            Constructor[] con1 = a.getDeclaredConstructors();
            for (Constructor c : con1){
                System.out.println(c.getName());
            }
            System.out.println("------------------------");



            int abc = "java.lang.Interger".lastIndexOf('.');
            System.out.println("getConstructor(null)方法获取类加载器：");
            Constructor con2 = a.getConstructor(null);
                System.out.println(con2);
            System.out.println("------------------------");

            System.out.println("getConstructor(有参数)方法获取类加载器：");
            Constructor con3 = a.getConstructor(new Class[]{String.class,String.class});
            System.out.println(con3);
            System.out.println("------------------------");


            System.out.println("\n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("获取所有属性");
            Field[] field = a.getFields();
            for (Field f: field){
                System.out.println(f);
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("getDeclaredFields获取所有属性");
            Field[] field1 = a.getDeclaredFields();
            for (Field f: field1){
                System.out.println(f);
            }


            System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("获取name属性");
            Field fi = a.getField("name");
            System.out.println(fi);
            Object o = a.getConstructor().newInstance();
            fi.set(o,"zzt");
            User u = (User) o;
            System.out.println(((User) o).name);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testForMethod() throws Exception {
        Class clazz = Class.forName("com.reflact.User");
//        Method[] methods = clazz.getMethods();
//        for (Method m : methods){
//            System.out.println(m);
//        }
//        Thread.sleep(5000);
//
//        System.out.println("获取所有的方法");
//        Method[] deMethod = clazz.getDeclaredMethods();
//        for (Method m :deMethod){
//            System.out.println(m);
//        }
//        Thread.sleep(5000);

//        System.out.println("获取特定方法：");
//        Method method = clazz.getMethod("publicmehtod2",Integer.class);
//        System.out.println(method);
//        Thread.sleep(5000);

        Method method = clazz.getDeclaredMethod("publicmehtod2",String.class);
        Object obj = clazz.getConstructor().newInstance();

        Object invoke = method.invoke(obj,"996");

        System.out.println(invoke);
    }

    @Test
    public void testReflactMain() throws Exception{
        Class clazz = Class.forName("com.reflact.User");
        Method main = clazz.getMethod("main",String[].class);

        main.invoke(null,(Object)new String[]{"hio","kop","jopj"});
    }
}
