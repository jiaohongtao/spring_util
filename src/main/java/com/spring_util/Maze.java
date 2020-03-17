package com.spring_util;

import java.util.Scanner;

/**
 * 简易迷宫问题_递归
 * article_address: https://blog.csdn.net/weixin_43570367/article/details/104609953
 */
public class Maze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i; // 横坐标
        int j; // 纵坐标

        // 创建一个10×10的迷宫地图
        int[][] map = new int[10][10];

        // 设置迷宫地图的左、右两边为墙，用“1”来代替墙面
        for (i = 0; i < 10; i++) {
            map[i][0] = 1;
            map[i][9] = 1;
        }

        // 设置迷宫地图的上、下两边为墙，用“1”来代替墙面
        for (i = 0; i < 10; i++) {
            map[0][i] = 1;
            map[9][i] = 1;
        }

        // 设置迷宫地图中的挡板位置
        map[4][1] = 1;
        map[4][2] = 1;
        map[4][3] = 1;
        map[1][6] = 1;
        map[2][6] = 1;

        System.out.println("迷宫地图的情况：");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("输入小明的起始点 m:");
        int m = scanner.nextInt();

        System.out.println("输入小明的起始点 n:");
        int n = scanner.nextInt();

        // 寻找迷宫的出路
        mazeTrack(map, m, n);

        System.out.println("小明走过，并标识的迷宫地图的情况：");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param maze 表示迷宫地图
     * @param i    小明从哪个位置开始找
     * @param j    小明从哪个位置开始找
     * @return 如果小明找到了通路，就返回true
     */
    public static boolean mazeTrack(int[][] maze, int i, int j) {
        if (maze[8][8] == 2) { // 如果迷宫中的（8,8）这个点标记为“2”，则说明小明已经找到了出口
            return true;
        } else {
            if (maze[i][j] == 0) { // 当前这个点还没走过
                maze[i][j] = 2;
                if (mazeTrack(maze, i - 1, j)) { // 探索向上走是否可行
                    return true;
                } else if (mazeTrack(maze, i, j + 1)) { // 探索向右走是否可行
                    return true;
                } else if (mazeTrack(maze, i + 1, j)) { // 探索向下走是否可行
                    return true;
                } else if (mazeTrack(maze, i, j - 1)) { // 探索向左走是否可行
                    return true;
                } else {
                    // 如果在探索过程中该点走不通，则标记为“3”
                    maze[i][j] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}

