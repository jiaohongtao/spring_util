package com.springutil.test.test_20200707;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年07月08日
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        Thread thread3 = new Thread(thread);
        Thread thread4 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class MyThread extends Thread {
    private int count = 4;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + ": count=" + count);

    }
}