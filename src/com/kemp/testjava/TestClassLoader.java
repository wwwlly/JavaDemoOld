package com.kemp.testjava;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestClassLoader {

    public static void main(String[] args){
        test3();
    }

    private static void test1(){
        A a = new B();
//        a.getClass().getClassLoader()
    }

    private static void test2(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class timeClass = classLoader.loadClass("com.kemp.testjava.TestTime");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 演示类加载器的树状组织结构
     */
    private static void test3(){
        ClassLoader loader = TestClassLoader.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}

class A{
    static {
        System.out.println("a static");
    }

    A(){
        System.out.println("a construction");
    }
}

class B extends A{
    static {
        System.out.println("b static");
    }

    B(){
        System.out.println("b construction");
    }
}
