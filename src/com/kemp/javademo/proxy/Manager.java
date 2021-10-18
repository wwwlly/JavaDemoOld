package com.kemp.javademo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Manager {

    public <T> T createService(Class<T> service){
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, (proxy, method, args) -> {
            System.out.println("======InvocationHandler.invoke()");
            System.out.println("======proxy: " + proxy.getClass().getSimpleName());
            System.out.println("======proxy's interface is: " + listInterfacesStr(proxy.getClass().getInterfaces()));
            System.out.println("======method: " + method.getName() + ",DeclaringClass: " + method.getDeclaringClass().getSimpleName());
            if(method.getDeclaringClass() == Object.class){
                System.out.println("object is an instance of declaring class");
                method.invoke(this, args);
                return proxy;
            }
            return new Call();
        });
    }

    public <T> T createService1(Class<T> service){
        return (T) Proxy.newProxyInstance(service.getClassLoader(), service.getInterfaces(), (proxy, method, args) -> {
            System.out.println("======InvocationHandler.invoke()");
            System.out.println("======proxy: " + proxy.getClass().getSimpleName());
            System.out.println("======proxy's interface is: " + listInterfacesStr(proxy.getClass().getInterfaces()));
            System.out.println("======method: " + method.getName() + ",DeclaringClass: " + method.getDeclaringClass().getSimpleName());
            if(method.getDeclaringClass() == Object.class){
                System.out.println("object is an instance of declaring class");
                Object obj = method.invoke(this, args);
                System.out.println("object name is " + obj.getClass().getName());
                return method.invoke(this, args);
            }
            return null;
        });
    }

    private String listInterfacesStr(Class<?>[] interfaces){
        if(interfaces == null){
            return "null";
        }

        StringBuilder str = new StringBuilder();
        for (Class<?> ii :interfaces) {
            str.append(ii.getSimpleName());
            str.append(",");
        }
        return str.toString();
    }
}
