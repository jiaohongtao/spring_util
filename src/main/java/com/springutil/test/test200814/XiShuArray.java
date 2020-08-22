package com.springutil.test.test200814;

import java.util.Arrays;

/**
 * 稀疏数组
 * href：https://www.bilibili.com/video/BV12J41137hu?p=59
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月22日
 */
public class XiShuArray {

    public static void main(String[] args) {
        // 1.创建一个二维数据组 11*11 0：没有棋子 1：黑棋 2：白棋
        int[][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        System.out.println("输出原始数组,长度为：" + array1.length);
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }


        // 转换为稀疏数组保存
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效值的个数：" + sum);
        // 2.创建稀疏数组
        int[][] array2 = new int[sum + 1][3];
        array2[0][0] = array1.length;
        array2[0][1] = array1.length;
        array2[0][2] = sum;

        // 遍历二维数组，将非零的值存放到稀疏数组中
        int count = 0; // 记录行数
        for (int i = 1; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                if (array1[i][j] != 0) {
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("array1的稀疏数组为：");
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        System.out.println("============");
        System.out.println("读取稀疏数组，还原为二维数组");
        // 读取 int[行][列]
        int[][] array3 = new int[array2[0][0]][array2[0][1]];
        // 给其中的元素还原它的值，因为第 0 行是 11，11，sum，记录数组的属性值，所以不用取
        /*for (int i = 1; i < array2.length; i++) {
            array3[ array2[i][0] ][ array2[i][1] ] = array2[i][2];
        }*/
        // 可以用这种跳过第一次不用取的情况
        Arrays.stream(array2).skip(1).forEach(arr -> array3[arr[0]][arr[1]] = arr[2]);

        System.out.println("输出还原的数组：");
        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
