package com.leetcode.medium;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int m = A.length;
        int n = A[0].length;

        //dp数组表示到[i， j]的最小下降路径和
        int[][] dp = new int[m][n];

        //第一行的最小下降路径和就是A数组本身
        for (int i = 0; i < m; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) { //如果在最左边 只比较上一位和上右一位
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                } else if (j == n - 1) {//如果在最右边 只比较上一位和上左一位
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                } else {//中间位置则比较上左、上、上右三个位置
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]), dp[i - 1][j - 1]) + A[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            res = Math.min(dp[m - 1][i], res);
        }

        return res;
    }
}
