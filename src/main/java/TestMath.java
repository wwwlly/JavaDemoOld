/**
 * Created by wangkp on 2017/12/5.
 */
public class TestMath {

    public static void main(String[] args) {
//        int fti = Float.floatToIntBits(11.5f);
//        System.out.println(fti);
//        System.out.println(Integer.toBinaryString(fti));
//        test1();
        testTrigonometric();
    }

    /**
     * Math.round(a)四舍五入，本质：a加上0.5然后向下取整
     * floor()向下取整
     * ceil()向上取整
     */
    private static void testRound() {
//        Math.round()
    }

    /**
     * 当一个基本类型变量被强转、被移位原值不变
     */
    private static void test1() {
        float a = 5.2f;
        int b = (int) a;
        System.out.println("a:" + a + ",b:" + b);
        int c = b << 1;
        System.out.println("b:" + b + ",c:" + c);
    }

    private static void testTrigonometric() {
        double s = Math.sin(Math.PI / 4);
        System.out.println("sin:" + s);
        double c = Math.cos(Math.PI / 2);
        System.out.println("cos:" + c);
        double d = Math.toRadians(180);
        System.out.format("pi 的值为 %.4f%n", d);
        double angle = 2 / 7 * Math.PI;
        System.out.println("angle:" + angle);
    }
}
