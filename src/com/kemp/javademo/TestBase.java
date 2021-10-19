package com.kemp.javademo;

/**
 * 基础
 */
public class TestBase {

    public static void main(String[] args) {
        testM();
        testI();
    }

    /**
     * 当两个方法重载后，调用的方法都符合语法时，走更具体的类型
     */
    private static void testM() {
        m(null);
    }

    public static void m(Object o) {
        System.out.println("Object...");
    }

    private static void m(String s) {
        System.out.println("String...");
    }

    /**
     * 运算符++
     */
    private static void testI() {
        int i = 0;
        i = i++ + ++i;
        System.out.println("i: " + i);
    }
}
