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

    /**
     * 跳出多重循环
     */
    private static void test(){
        A://标记
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j ++){
                if(i == 2 && j == 1){
                    break A;
                }
            }
        }
    }
}
