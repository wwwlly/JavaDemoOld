import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkp on 2017/12/1.
 */
public class TestFor {

    private static int i = 0;

    public static void main(String[] args) {
        test3();
    }

    private static void initFor() {
        System.out.println("initFor");
    }

    private static boolean condition() {
        System.out.println("condition");
        return i < 3;
    }

    private static void change() {
        i++;
        System.out.println("change");
    }

    /**
     * 跳出多重循环
     */
    private static void test() {
        A:
//标记
        for (int i = 0; i < 5; i++) {
            System.out.println("i:" + i);
            for (int j = 0; j < 3; j++) {
                System.out.println("j:" + j);
                if (i == 2 && j == 1) {
                    break A;
                }
            }
        }
    }

    /**
     * 测试break、continue
     * continue:用于结束循环体中其后语句的执行，并跳回循环程序块的开头执行下一次循环，而不是立刻循环体。
     * break:作用是跳出当前循环块（for、while、do while）或程序块（switch）。
     * 在循环块中的作用是跳出当前正在循环的循环体。在程序块中的作用是中断和下一个case条件的比较。
     */
    private static void test1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i:" + i);
            if (i == 1) {
//                continue;
                break;
            }
            System.out.println("end");
        }
    }

    private static void test2() {
        for (initFor(); condition(); change()) {
            System.out.println("test for");
        }
    }

    private static void test3() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + 1 + "");
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
            if (list.get(i).equals("3")) {
                list.remove("3");
                break;
            }
        }
        System.out.println("======");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
