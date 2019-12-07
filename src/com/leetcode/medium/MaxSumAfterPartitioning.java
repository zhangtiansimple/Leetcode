package com.leetcode.medium;


/**
 *
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
 *
 * 返回给定数组完成分隔后的最大和。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 *
 *
 *
 * 提示：
 *
 *     1 <= K <= A.length <= 500
 *     0 <= A[i] <= 10^6
 *
 * */

public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //dp数组表示[0...i]的最大和
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            //最大值初始化为A[i]
            int max = A[i];
            //i - (j - 1) >= 0 保证前面有j - 1个元素
            for (int j = 1; j <= K && i - (j - 1) >= 0; j++) {
                //状态转移方程
                max = Math.max(max, A[i - j + 1]);;
                dp[i] = Math.max(dp[i], ((i - j < 0) ? 0 : dp[i - j]) + j * max);
            }
        }
        return dp[A.length - 1];
    }
}
