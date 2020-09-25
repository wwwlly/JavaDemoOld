package com.kemp.javademo;

/**
 * Created by wangkp on 2017/12/6.
 */
public class TestString {

    public static void main(String[] args){
//        test();
        test1();
    }

    private static void test(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        String s4 = "Programming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println(s1 == s4);
        //一下都为true
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s1.equals(s1.intern()));
    }

    private static void test1(){
        String s = "abc";
        s = "bcd";
        System.out.println("s: " + s);
    }
}
