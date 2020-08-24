package com.springutil.test.test_20200707;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年07月08日
 */
public class ThreadTest {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        Thread t1 = new Thread(saleThread, "窗口1");
        Thread t2 = new Thread(saleThread, "窗口2");

        t1.start();
        t2.start();
    }
}

class SaleThread implements Runnable {
    private int total = 1;//总票数
    private int count = total;//剩余票数

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public synchronized void sale() {
        if (count > 0) {
            count--;
            System.out.println(String.format("%s出售了第%d张票", Thread.currentThread().getName(), total - count));
        }
    }
}