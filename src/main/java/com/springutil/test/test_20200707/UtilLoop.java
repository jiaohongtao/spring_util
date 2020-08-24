package com.springutil.test.test_20200707;

import java.util.Date;

/**
 * for无限循环
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020/7/7 22:40
 */
public class UtilLoop {

    public static void main(String[] args) {

        for (; ; ) {
            System.out.println(new Date());
            System.out.println("我执行了");
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().setName("MAIN");
            System.out.println("重写当前线程名称为：" + Thread.currentThread().getName());
            System.out.println("===我睡5秒====");
            try {
                Thread.sleep(5 * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
