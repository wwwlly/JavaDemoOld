package com.kemp.javademo;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

/**
 * 参考:https://blog.csdn.net/wangqiankun2010/article/details/87873417
 * HashMap 方法不是同步的，支持key和value为null的情况
 * Hashtable java早期提供的，方法是同步的（加了synchronized）。key和value都不能是null值。
 * LinkedHashMap 拥有 HashMap 的所有特性，它比 HashMap 多维护了一个双向链表，
 * 因此可以按照插入的顺序从头部或者从尾部迭代，是有序的
 * TreeMap 底层就是一颗红黑树，它的 containsKey , get , put and remove 方法的时间复杂度是 log(n) ，
 * 并且它是按照 key 的自然顺序（或者指定排序）排列，与 LinkedHashMap 不同， LinkedHashMap 保证了元素
 * 是按照插入的顺序排列。
 */
public class MapDemo {

    public static void main(String[] args) {
        System.out.println("a2 hash: " + hash("a2") + ", a3 hash: " + hash("a3"));
        testHashMap();
        testLinkedHashMap();
        testTreeMap();
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static void testHashMap(){
        System.out.println("testHashMap");
        Map<String, String> map = new HashMap<String, String>();
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.print(name + " ");
        }
        System.out.print("\n");
    }

    private static void testLinkedHashMap(){
        System.out.println("testLinkedHashMap");
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.print(name + " ");
        }
        System.out.print("\n");
    }

    private static void testTreeMap(){
        System.out.println("testTreeMap");
        Map<String, String> map = new TreeMap<String, String>(new Comparator<Object>(){
            Collator collator = Collator.getInstance();
            public int compare(Object o1, Object o2) {
                CollationKey key1 = collator.getCollationKey(o1.toString());
                CollationKey key2 = collator.getCollationKey(o2.toString());
                return key1.compareTo(key2);
                //return collator.compare(o1, o2);
            }});
        map.put("a3", "aa");
        map.put("a2", "bb");
        map.put("b1", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.print(name + " ");
        }
        System.out.print("\n");
    }
}
