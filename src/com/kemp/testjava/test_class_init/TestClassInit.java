package com.kemp.testjava.test_class_init;

/**
 * �������static�������������Եļ���˳��
 */
public class TestClassInit {

    ClassA classA = new ClassA();

    TestClassInit(){
        System.out.println("TestClassInit constructor init");
    }

    static{
        System.out.println("TestClassInit static init");
    }

    public static void main(String[] args){
        TestClassInit init = new TestClassInit();
    }
}
