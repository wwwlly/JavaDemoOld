package com.kemp.testjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestList {

    public static void main(String args[]){
        test();
    }

    /**
     * foreach �ᱨConcurrentModificationException��
     * forȴ���ᱨ��
     */
    private static void test(){
        List<String> list = new ArrayList<>();
        list.add("1");
//        for(int i = 0; i < list.size(); i ++){
//            list.remove("1");
//        }
        for(String s: list){
            list.remove(s);
        }
        System.out.println(list.size());
    }
}
