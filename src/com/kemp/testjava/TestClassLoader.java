package com.kemp.testjava;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestClassLoader {

    public static void main(String[] args){
        A a = new B();
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
