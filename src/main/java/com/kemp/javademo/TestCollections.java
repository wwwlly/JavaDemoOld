package com.kemp.javademo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();

        list.add('X');
        list.add('Y');

        System.out.println("Initial list: "+ list);

        List<Character> immutablelist = Collections.unmodifiableList(list);
//        immutablelist.add('Z');

        list.add('Z');
        System.out.println("Initial list: "+ list);
    }
}
