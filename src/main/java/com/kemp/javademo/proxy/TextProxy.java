package com.kemp.javademo.proxy;

import java.util.HashMap;

/**
 * 动态代理
 */
public class TextProxy {

    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();

        Manager manager = new Manager();
        Service service = manager.createService(Service.class);
        service.test();

        Service1 service1 = manager.createService1(Service1.class);
        service1.test();
    }
}
