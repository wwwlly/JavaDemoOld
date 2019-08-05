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
     * ��������ѭ��
     */
    private static void test() {
        A:
//���
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
     * ����break��continue
     * continue:���ڽ���ѭ�������������ִ�У�������ѭ�������Ŀ�ͷִ����һ��ѭ��������������ѭ���塣
     * break:������������ǰѭ���飨for��while��do while�������飨switch����
     * ��ѭ�����е�������������ǰ����ѭ����ѭ���塣�ڳ�����е��������жϺ���һ��case�����ıȽϡ�
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
