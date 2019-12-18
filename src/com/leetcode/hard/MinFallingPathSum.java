package com.leetcode.hard;

/**
 *
 * 给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 * 请你返回非零偏移下降路径数字和的最小值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 *
 *
 *
 * 提示：
 *
 *     1 <= arr.length == arr[i].length <= 200
 *     -99 <= arr[i][j] <= 99
 *
 * */

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int m = arr.length, n = arr[0].length;

        //dp数组表示下降到[i，j]的最小路径和
        int[][] dp = new int[m][n];

        //第一行就是arr数组第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //状态转移方程 ：dp[i,j] = arr[i][j] + min(dp[i - 1, j])
                dp[i][j] = arr[i][j] + getMin(dp[i - 1], j);
            }
        }

        return getMin(dp[m - 1], -1);
    }

    //寻找不相邻的j的最小值
    private int getMin(int[] arr, int cow){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i != cow) {
                min = Math.min(min, arr[i]);
            }
        }
        return min;
    }
}
