package com.kemp.javademo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * Created by wangkp on 2017/12/7.
 */
public class TestClassLoader {

    public static void main(String[] args){
        test1();
//        test2();
//        test4();
    }

    /**
     * java的执行顺序：
     * 1.先执行static代码（无论是static变量还是static代码块，同时存在则顺序执行）且先执行父类的然后执行子类的，在执行以下的；
     * 2.然后执行属性初始化和普通代码块（同时存在顺序执行）然后执行构造方法，同样先执行父类的然后执行子类的；
     */
    private static void test1(){
        Parent parent = new Son();
        System.out.println("new com.kemp.javademo.Son()");
        Son son = new Son();
//        a.getClass().getClassLoader()
    }

    private static void test2(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class sonClass = classLoader.loadClass("com.kemp.javademo.Son");
            Son son = (Son) sonClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
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

    private static void test4(){
        SuperClass<Cat> superClass = new SubClass();
        System.out.println(superClass.getBeanClass());
    }

    public abstract static class SuperClass<T> {

        private Class<T> beanClass;
        @SuppressWarnings("unchecked")
        public SuperClass() {
            super();
            ParameterizedType parameterizedType =  (ParameterizedType) getClass().getGenericSuperclass();
            Type[] types = parameterizedType.getActualTypeArguments();
            beanClass = (Class<T>) types[0];
        }

        public Class<T> getBeanClass() {
            return beanClass;
        }

        public void setBeanClass(Class<T> beanClass) {
            this.beanClass = beanClass;
        }

    }

    public static class SubClass extends SuperClass<Cat> {

        public SubClass() {
            super();
        }

    }

    static class Cat {

        public Cat() {
            super();
        }
    }
}

/**
 * 静态代码块和构造代码块的异同点
 * 相同点：都是JVM加载类后且在构造函数执行之前执行，在类中可定义多个，一般在代码块中对一些static变量进行赋值。
 * 不同点：静态代码块在非静态代码块之前执行。静态代码块只在第一次new时执行一次，之后不在执行。而非静态代码块每new一次就执行一次。
 */
class Parent{

    int a = init();

    static {
        System.out.println("com.kemp.javademo.Parent static");
    }

    {
        System.out.println("com.kemp.javademo.Parent 代码块1");
    }

    {
        System.out.println("com.kemp.javademo.Parent 代码块2");
    }

    Parent(){
        System.out.println("com.kemp.javademo.Parent construction");
    }

    int init(){
        a = 1;
        System.out.println("com.kemp.javademo.Parent a int");
        return 2;
    }
}

class Son extends Parent{

    static int a = inita();

    int b = initb();

    static {
        System.out.println("com.kemp.javademo.Son static");
    }

    {
        System.out.println("com.kemp.javademo.Son 代码块1");
    }

    {
        System.out.println("com.kemp.javademo.Son 代码块2");
    }

    Son(){
        System.out.println("com.kemp.javademo.Son construction");
    }

    static int inita(){
        System.out.println("com.kemp.javademo.Son a int");
        return 1;
    }

    int initb(){
        System.out.println("com.kemp.javademo.Son b int");
        return 2;
    }
}
