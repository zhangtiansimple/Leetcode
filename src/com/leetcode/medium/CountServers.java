package com.leetcode.medium;

/**
 *
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * */

public class CountServers {
    public int countServers(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;

        //存储行的和
        int[] r = new int[grid.length];
        //存储列的和
        int[] c = new int[grid[0].length];

        //计算和的和
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
            }
            r[i] = sum;
        }

        //计算列的和
        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum += grid[j][i];
            }
            c[i] = sum;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //如果这台服务器的行和或者列和大于1 就表示可以通信
                if (grid[i][j] == 1 && (r[i] > 1 || c[j] > 1)) {
                    res++;
                }
            }
        }

        return res;
    }
}
