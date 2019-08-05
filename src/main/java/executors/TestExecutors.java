package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutors {

    public static void main(String[] args) {
        testInner();
        test1();
        test2();
    }

    private static void testInner() {
        //Ƕ������÷�
        TestExecutors testExecutors = new TestExecutors();
        TestExecutors.Inner inner = testExecutors.new Inner();
        inner.test();
    }

    private static void test1() {
        //����һ�������ù̶��߳������̳߳�

        //����һ�����̵߳��̳߳ء�����̳߳�ֻ��һ���߳��ڹ�����Ҳ�����൱�ڵ��̴߳���ִ����������
        // ������Ψһ���߳���Ϊ�쳣��������ô����һ���µ��߳����������
        // ���̳߳ر�֤���������ִ��˳����������ύ˳��ִ�С�
//        ExecutorService pool = Executors.newSingleThreadExecutor();

        //�����̶���С���̳߳ء�ÿ���ύһ������ʹ���һ���̣߳�ֱ���̴߳ﵽ�̳߳ص�����С��
        // �̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�
//        ExecutorService pool = Executors.newFixedThreadPool(2);

        //����һ���ɻ�����̳߳ء�����̳߳صĴ�С�����˴�����������Ҫ���̣߳�
        //��ô�ͻ���ղ��ֿ��У�60�벻ִ�����񣩵��̣߳�������������ʱ�����̳߳��ֿ������ܵ�������߳�����������
        // ���̳߳ز�����̳߳ش�С�����ƣ��̳߳ش�С��ȫ�����ڲ���ϵͳ������˵JVM���ܹ�����������̴߳�С��
        ExecutorService pool = Executors.newCachedThreadPool();

        //����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
        Thread t1 = new MyThread();

        Thread t2 = new MyThread();

        Thread t3 = new MyThread();

        Thread t4 = new MyThread();

        Thread t5 = new MyThread();

        //���̷߳�����н���ִ��
        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //�ر��̳߳�
        pool.shutdown();
    }

    private static void test2() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(() -> {//ÿ��һ��ʱ��ʹ����쳣
            System.out.println("================");

        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//ÿ��һ��ʱ���ӡϵͳʱ�䣬֤�������ǻ���Ӱ���

            @Override

            public void run() {

                System.out.println(System.nanoTime());

            }

        }, 1000, 2000, TimeUnit.MILLISECONDS);


    }

    public static class MyThread extends Thread {

        @Override

        public void run() {

            System.out.println(Thread.currentThread().getName() + "����ִ�С�����");

        }

    }

    private class Inner {

        private void test() {
            System.out.println("test inner.");
        }
    }
}
