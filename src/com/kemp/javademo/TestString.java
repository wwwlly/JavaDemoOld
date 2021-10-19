package com.kemp.javademo;

/**
 * 参考：https://www.cnblogs.com/justcooooode/p/7603381.html
 * Created by wangkp on 2017/12/6.
 */
public class TestString {

    public static void main(String[] args) {
        test();
        testEquals();
        test1();
    }

    /**
     * ==
     * 基本类：比较的是它们的值，复合类型：比较的是它们的内存地址
     * equals 封装的方法
     * 字符串缓冲池：程序在运行的时候会创建一个字符串缓冲池。
     * 创建字符串的时候先查找字符串缓冲池中有没有相同的对象，如果有相同的对象就直接返回该对象的引用，
     * 如果没有相同的对象就在字符串缓冲池中创建该对象，然后将该对象的引用返回。
     * String s3 = "Program" + "ming"; 等价于 String s3 = "Programming";（编译器处理）
     * intern()： 如果常量池中存在当前字符串, 就会直接返回当前字符串. 如果常量池中没有此字符串, 会将此字符串放入常量池中后, 再返回
     */
    private static void testEquals() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        String s4 = "Programming";
        String s5 = new String("Programming");
        String s6 = "Program" + new String("ming");
        String s7 = "Program";
        String s8 = "ming";
        String s9 = s7 + s8;
        StringBuffer s10 = new StringBuffer(s1);

        System.out.println("==:");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println(s1 == s4);
        System.out.println(s2 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s9);

        System.out.println("equals:");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s1.intern()));
        System.out.println(s1.equals(s10));
    }

    private static void test() {
        String s = "abc";
        s = "bcd";
        System.out.println("s: " + s);
    }

    /**
     * 注意运算符优先级
     * +的优先级大于==
     */
    private static void test1() {
        System.out.println("TestString.test1");
        String s1 = "abc";
        String s2 = "abc";
        System.out.println("=====>" + s1 == s2);
    }
}
