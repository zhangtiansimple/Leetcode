package com.leetcode.medium;

import java.util.List;

/**
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * */

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        //建立一个dp数组，保存从顶下到当前位置的最小代价
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) { //如果是第一个位置，只能从上一行的第一个位置下来
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {//如果是最后一个位置，只能从上一行的最后一个位置下来
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {//如果是中间位置，就比较上面的两个位置，哪个小就加哪个
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;

        //最后从dp数组的最后一行选取最小值即为最优解
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }
}
