package com.kemp.testjava;

/**
 * �����㷨
 */
public class TestSort {

    /**
     * ð������
     * <p>
     * ���ظ����߷ù�Ҫ�����Ԫ���У�һ�αȽ��������ڵ�Ԫ�أ�������ǵ�˳����Ӵ�С������ĸ��A��Z������Ͱ����ǽ���������
     * �߷�Ԫ�صĹ������ظ��ؽ���ֱ��û������Ԫ����Ҫ������Ҳ����˵��Ԫ���Ѿ�������ɡ�
     */
    private static void bubbleSort(int[] arrs) {
        boolean flag = false;
        //Ϊʲô��arrs.length - 1�ˣ�����5�������մ��㷨�����4�����Ϳ�����
        for (int i = 0; i < arrs.length - 1; i++) {
            flag = false;
            for (int j = arrs.length - 1; j > i; j--) {
                if (arrs[j] > arrs[j - 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j - 1];
                    arrs[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            printArrays(arrs);
        }
    }

    /**
     * ѡ������
     * <p>
     * ѡ������Selection sort����һ�ּ�ֱ�۵������㷨�����Ĺ���ԭ����ÿһ�δӴ����������Ԫ����ѡ����С������󣩵�һ��Ԫ�أ�
     * ��������е���ʼλ�ã�ֱ��ȫ�������������Ԫ�����ꡣ ѡ�������ǲ��ȶ������򷽷�����������[5�� 5�� 3]��һ�ξͽ���һ��[5]��[3]������
     * ���µ�һ��5Ų�����ڶ���5���棩��
     */
    private static void selectionSort(int[] arrs) {
        int size = arrs.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arrs[j] < arrs[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arrs[i];
            arrs[i] = arrs[minIndex];
            arrs[minIndex] = temp;
        }
    }

    /**
     * ��������
     * <p>
     * ��������Ļ����������ǽ�һ�����ݲ��뵽�Ѿ��ź�������������У��Ӷ��õ�һ���µġ�������һ���������ݣ��㷨�������������ݵ�����
     * ʱ�临�Ӷ�ΪO(n^2)�����ȶ������򷽷���
     *
     * @param arrs
     */
    private static void insertSort(int[] arrs) {
        if (arrs == null || arrs.length < 2) {
            return;
        }
        int size = arrs.length;
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arrs[j] < arrs[j - 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j - 1];
                    arrs[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * ��������
     * ��������Quicksort���Ƕ�ð�������һ�ָĽ���
     * ���Ļ���˼���ǣ�ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
     * Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
     *
     * @param arrs
     */
    private static void quickSort(int[] arrs, int low, int high) {

        int l = low;
        int h = high;
        int key = arrs[low];
        while (l < h) {

            while (l < h && arrs[h] >= key)//���������ҵ�һ��С��key��ֵ
                h--;
            if (l < h) {
                arrs[l] = arrs[h];
                l++;
            }

            while (l < h && arrs[l] < key)//���������ҵ�һ������key��ֵ
                l++;
            if (l < h) {
                arrs[h] = arrs[l];
                h--;
            }
            arrs[l] = key;

            System.out.println("start l:" + l + ",h:" + h);
            printArrays(arrs);

            quickSort(arrs, low, l - 1);
            quickSort(arrs, l + 1, high);
            System.out.println("end l:" + l + ",h:" + h);
        }

    }

    public static void main(String[] args) {
        int[] arrs = new int[]{25, 45, 56, 12, 5, 89, 33};
//        bubbleSort(arrs);
//        selectionSort(arrs);
//        insertSort(arrs);
        quickSort(arrs, 0, arrs.length - 1);

        printArrays(arrs);
    }

    private static void printArrays(int[] arrs) {
        System.out.print("[");
        for (int i = 0; i < arrs.length; i++) {
            if (i == arrs.length - 1) {
                System.out.print(arrs[i]);
            } else {
                System.out.print(arrs[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.print("\n");
    }
}
