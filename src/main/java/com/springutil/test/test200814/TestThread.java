package com.springutil.test.test200814;

import java.io.IOException;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月27日
 */
public class TestThread extends Thread {
    public TestThread() {
        super("hongtao");
    }

    /**
     * 线程的run方法，它将和其他线程同时运行
     */
    @Override
    public void run() {
        for (int i = 1; i <= 40; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("TestThread: " + Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {
        TestThread test = new TestThread();
        test.setDaemon(true);
        test.start();
        System.out.println("isDaemon = " + test.isDaemon());
        try {
            // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
            System.out.println("请输入：");
            int read = System.in.read();
            System.out.println("输入的字符对应ASCII码数字为：" + read);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}