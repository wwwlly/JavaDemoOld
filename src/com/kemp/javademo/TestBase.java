package com.kemp.javademo;

/**
 * 基础
 * 方法重载
 * i++
 * 基本类型
 */
public class TestBase {

    public static void main(String[] args) {
        testM();
        testI();
        testEncode();
        testFloat();
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
     * 运算符 i++
     * i++是把局部变量表中保存的数据复制到栈帧中栈顶的位置，然后对局部变量表中的原数据进行+1操作，
     * 最后再用栈桢中栈顶的值覆盖局部变量表中的原数据。相当于变量i的值没变
     * 参考：https://zhuanlan.zhihu.com/p/40645506
     */
    private static void testI() {
        System.out.println("TestBase.testI");
        int i = 0;
        i = i++ + ++i;
        System.out.println("i: " + i);

        i = 10;
        i = i++;
        System.out.println("i: " + i);
    }

    /**
     * byte：8位，最大存储数据量是255，存放的数据范围是-128~127之间。
     * short：16位，最大数据存储量是65536，数据范围是-32768~32767之间。
     * int：32位，最大数据存储容量是2的32次方减1，数据范围是负的2的31次方到正的2的31次方减1。
     * long：64位，最大数据存储容量是2的64次方减1，数据范围为负的2的63次方到正的2的63次方减1。
     * float：32位，数据范围在3.4e-45~1.4e38，直接赋值时必须在数字后加上f或F。
     * double：64位，数据范围在4.9e-324~1.8e308，赋值时可以加d或D也可以不加。
     * boolean：只有true和false两个取值。
     * char：16位，存储Unicode码，用单引号赋值。
     * <p>
     * 原码：第一位表示符号，正数用0表示，负数用1表示
     * 反码：正数的反码是其本身，负数的反码是在其原码的基础上, 符号位不变，其余各个位取反
     * 补码：正数的补码就是其本身，负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
     */
    private static void testEncode() {
        /*
        原码：10000000 00000000 00000000 10010100
        反码：11111111 11111111 11111111 01101011
        补码：11111111 11111111 11111111 01101100
         */
        int num = -148;
        System.out.println(Integer.toBinaryString(num));
        byte b = (byte) num;
        System.out.println("b: " + b);
    }

    /**
     * 0.1对于十进制来说是能除尽的，但对于二进制来说是除不尽的
     */
    private static void testFloat() {
        System.out.println("TestBase.testFloat");
        System.out.println(0.1 * 3 == 0.3);
    }
}
