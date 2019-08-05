/**
 * Inner Class（内部类）定义在类中的类。
 * Nested Class（嵌套类）是静态（static）内部类。
 * Anonymous Inner Class （匿名内部类）匿名的内部类是没有名字的内部类。
 * 匿名内部类可以继承其他类，但不能用extends；可以实现某一个接口，但不能用implements。
 * 匿名内部类顾名思义没有名字的内部类，没有名字就不能有构造器，就必须调用基类的构造器，所以当然可以继承
 * Created by wangkp on 2017/12/7.
 */
public class TestAnonymous {

    public static void main(String[] args) {
        test(new Test(){});
    }

    private static void test(Test test) {

    }

}

class Test {

}

class Test1 {

}

interface Test2 {

}
