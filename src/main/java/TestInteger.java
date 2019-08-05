/**
 * Created by wangkp on 2017/12/1.
 */
public class TestInteger {

    public static void main(String[] args) {
        test5();
    }

    private static void test1() {
        Integer a = new Integer(3);
        Integer b = 3;                  // ��3�Զ�װ���Integer����
        int c = 3;
        System.out.println(a == b);     // false ��������û������ͬһ����
        System.out.println(a == c);     // true a�Զ������int�����ٺ�c�Ƚ�
    }

    private static void test2() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);//һֱΪtrue
        System.out.println(f3 == f4);//һֱΪfalse
        // ע�����f1��f2��f3��f4�ĸ���������Integer�������ã�
        // ���������==����ȽϵĲ���ֵ�������á�
        // װ��ı�����ʲô�أ������Ǹ�һ��Integer����һ��intֵ��ʱ�򣬻����Integer��ľ�̬����valueOf������
        // ���������������ֵ��-128��127֮�䣬��ô����new�µ�Integer���󣬶���ֱ�����ó������е�Integer����
        // �����������������f1==f2�Ľ����true����f3==f4�Ľ����false��
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
