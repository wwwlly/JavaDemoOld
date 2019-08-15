import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestClassLoader {

    public static void main(String[] args){
        test1();
//        test4();
    }

    private static void test1(){
        Parent parent = new Son();
        System.out.println("new Son()");
        Son son = new Son();
//        a.getClass().getClassLoader()
    }

    private static void test2(){
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
            Class timeClass = classLoader.loadClass("com.kemp.testjava.TestTime");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ʾ�����������״��֯�ṹ
     */
    private static void test3(){
        ClassLoader loader = TestClassLoader.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }

    private static void test4(){
        SuperClass<Cat> superClass = new SubClass();
        System.out.println(superClass.getBeanClass());
    }

    public abstract static class SuperClass<T> {

        private Class<T> beanClass;
        @SuppressWarnings("unchecked")
        public SuperClass() {
            super();
            ParameterizedType parameterizedType =  (ParameterizedType) getClass().getGenericSuperclass();
            Type[] types = parameterizedType.getActualTypeArguments();
            beanClass = (Class<T>) types[0];
        }

        public Class<T> getBeanClass() {
            return beanClass;
        }

        public void setBeanClass(Class<T> beanClass) {
            this.beanClass = beanClass;
        }

    }

    public static class SubClass extends SuperClass<Cat> {

        public SubClass() {
            super();
        }

    }

    static class Cat {

        public Cat() {
            super();
        }
    }
}

/**
 * ��̬�����͹����������ͬ��
 * ��ͬ�㣺����JVM����������ڹ��캯��ִ��֮ǰִ�У������пɶ�������һ���ڴ�����ж�һЩstatic�������и�ֵ��
 * ��ͬ�㣺��̬������ڷǾ�̬�����֮ǰִ�С���̬�����ֻ�ڵ�һ��newʱִ��һ�Σ�֮����ִ�С����Ǿ�̬�����ÿnewһ�ξ�ִ��һ�Ρ�
 */
class Parent{

    int a = init();

    static {
        System.out.println("Parent static");
    }

    {
        System.out.println("Parent �����1");
    }

    {
        System.out.println("Parent �����2");
    }

    Parent(){
        System.out.println("Parent construction");
    }

    int init(){
        a = 1;
        System.out.println("Parent a int");
        return 2;
    }
}

class Son extends Parent{

    int b = initb();

    static {
        System.out.println("Son static");
    }

    {
        System.out.println("Son �����1");
    }

    {
        System.out.println("Son �����2");
    }

    Son(){
        System.out.println("Son construction");
    }

    int initb(){
        System.out.println("Son b int");
        return 2;
    }
}
