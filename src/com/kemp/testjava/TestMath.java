package com.kemp.testjava;

/**
 * Created by wangkp on 2017/12/5.
 */
public class TestMath {

    public static void main(String[] args) {
//        int fti = Float.floatToIntBits(11.5f);
//        System.out.println(fti);
//        System.out.println(Integer.toBinaryString(fti));
        test1();
    }

    /**
     * Math.round(a)�������룬���ʣ�a����0.5Ȼ������ȡ��
     * floor()����ȡ��
     * ceil()����ȡ��
     */
    private static void testRound() {
//        Math.round()
    }

    /**
     * ��һ���������ͱ�����ǿת������λԭֵ����
     */
    private static void test1() {
        float a = 5.2f;
        int b = (int) a;
        System.out.println("a:" + a + ",b:" + b);
        int c = b << 1;
        System.out.println("b:" + b + ",c:" + c);
    }
}
