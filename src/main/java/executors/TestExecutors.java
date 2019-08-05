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
        //嵌套类的用法
        TestExecutors testExecutors = new TestExecutors();
        TestExecutors.Inner inner = testExecutors.new Inner();
        inner.test();
    }

    private static void test1() {
        //创建一个可重用固定线程数的线程池

        //创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
        // 如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。
        // 此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
//        ExecutorService pool = Executors.newSingleThreadExecutor();

        //创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
        // 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
//        ExecutorService pool = Executors.newFixedThreadPool(2);

        //创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
        //那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
        // 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();

        Thread t2 = new MyThread();

        Thread t3 = new MyThread();

        Thread t4 = new MyThread();

        Thread t5 = new MyThread();

        //将线程放入池中进行执行
        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池
        pool.shutdown();
    }

    private static void test2() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(() -> {//每隔一段时间就触发异常
            System.out.println("================");

        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的

            @Override

            public void run() {

                System.out.println(System.nanoTime());

            }

        }, 1000, 2000, TimeUnit.MILLISECONDS);


    }

    public static class MyThread extends Thread {

        @Override

        public void run() {

            System.out.println(Thread.currentThread().getName() + "正在执行。。。");

        }

    }

    private class Inner {

        private void test() {
            System.out.println("test inner.");
        }
    }
}
