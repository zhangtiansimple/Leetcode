package com.leetcode.medium;

public class MinPathSum {
    //这道题目和62号 63号问题也是类似的 前两道题目是计算路径和 而本题是计算路径的最小花费 只需要在dp递推的时候 计算最小花费即可
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        //单向的路径为上一位花费加当前位花费
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //从上面下来的花费小还是从左边过来的花费小
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
