package com.kemp.testjava;

/**
 * Created by wangkp on 2017/12/1.
 */
public class TestFor {

    private static int i = 0;

    public static void main(String[] args) {
        for (initFor(); condition(); change()) {
            System.out.println("test for");
        }
    }

    private static void initFor() {
        System.out.println("initFor");
    }

    private static boolean condition() {
        System.out.println("condition");
        return i < 3;
    }

    private static void change() {
        i++;
        System.out.println("change");
    }
}
