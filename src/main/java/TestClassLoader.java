import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wangkp on 2017/12/7.
 */
public class TestClassLoader {

    public static void main(String[] args){
        test4();
    }

    private static void test1(){
        A a = new B();
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
     * 演示类加载器的树状组织结构
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

class A{
    static {
        System.out.println("a static");
    }

    A(){
        System.out.println("a construction");
    }
}

class B extends A{
    static {
        System.out.println("b static");
    }

    B(){
        System.out.println("b construction");
    }
}
