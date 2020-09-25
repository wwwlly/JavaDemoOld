package com.kemp.javademo;

/**
 * Created by wangkp on 2017/12/1.
 */
public class TestInteger {

    public static void main(String[] args) {
        test5();
    }

    private static void test1() {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
    }

    private static void test2() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);//一直为true
        System.out.println(f3 == f4);//一直为false
        // 注意的是f1、f2、f3、f4四个变量都是Integer对象引用，
        // 所以下面的==运算比较的不是值而是引用。
        // 装箱的本质是什么呢？当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf方法。
        // 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
        // 所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
    }

    //Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
    private static void test3() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        int temp = Integer.MAX_VALUE + 1;
        System.out.println(temp);
    }

    private static void test4(){
        System.out.println(IntegerCache.low);
        System.out.println(IntegerCache.high);
        System.out.println(IntegerCache.cache[0] + "," + IntegerCache.cache[IntegerCache.cache.length - 1] + "," + IntegerCache.cache.length);
    }

    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = Integer.parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }

    private static void test5(){
        int VISIBILITY_MASK = 0x0000000C;
        System.out.println(Integer.toHexString(16));
        System.out.println(Integer.toBinaryString(0x08000000));
        System.out.println(Integer.toBinaryString(VISIBILITY_MASK));
        int SOUND_EFFECTS_ENABLED = 0x08000000;
        int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
        int mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED;
        System.out.println(Integer.toBinaryString(mViewFlags));
    }
}
