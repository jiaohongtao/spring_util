package com.springutil.test.test_20200707;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年07月08日
 */
public class LockTest {

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        // 线程1
        Thread t1 = new Thread(() -> {
            // Thread.currentThread()  返回当前线程的引用
            lockTest.method(Thread.currentThread());
        }, "t1");
        // 线程2
        Thread t2 = new Thread(() -> lockTest.method(Thread.currentThread()), "t2");

        t1.start();
        t2.start();
    }

    // ReentrantLock是Lock的子类
    private final Lock lock = new ReentrantLock();

    private void method(Thread thread) {
        // 获取锁对象
        lock.lock();
        try {
            System.out.println("线程名：" + thread.getName() + "获得了锁");
            // Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // 释放锁对象
            System.out.println("线程名：" + thread.getName() + "释放了锁");
        }
    }

}
