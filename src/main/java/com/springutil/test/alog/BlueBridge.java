package com.springutil.test.alog;

import java.math.BigInteger;

/**
 * 蓝桥杯2019年第十届 Java B组真题题目 3.数列求值
 * https://blog.csdn.net/m0_47256162/article/details/110526043
 * 题目描述：
 * <p>
 * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。
 * 求 第 20190324 项的最后 4 位数字。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。
 * 本题的结果为一个 4 位整数（提示：答案的千位不为 0），
 * 在提交答案时只填写这个整数，填写 多余的内容将无法得分。
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年12月04日
 */
public class BlueBridge {

    public static void main(String[] args) {
        // 第一种快，应该是int占的字节少的原因
        System.out.println(getNum(20190324));
        System.out.println(getNumFibo(20190324));
    }

    public static int getNum(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 1;
        for (int i = 3; i < n; i++) {
            d = a % 10000 + b % 10000 + c % 10000;
            a = b;
            b = c;
            c = d;
        }
        return d % 10000;
    }

    public static BigInteger getNumFibo(int n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        BigInteger d = BigInteger.ONE;
        for (int i = 3; i < n; i++) {
            // 计算第四个值，即需要的值
            d = a.mod(new BigInteger("10000"))
                    .add(b.mod(new BigInteger("10000")))
                    .add(c.mod(new BigInteger("10000")));
            // 交换值
            a = b;
            b = c;
            c = d;
        }
        return d.mod(new BigInteger("10000"));
    }
}
