package com.leetcode.medium;

import java.util.Arrays;

/**
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 *     可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *     你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * */

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        //设置dp数组 代表当前位置的最长上升子序列
        int[] dp = new int[nums.length];
        //给dp数组设置默认值 因为最小的上升子序列就是本身 所有全部赋值为1
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//如果nums[i] > nums[j] 则可以更新dp数组
                    dp[i] = Math.max(dp[j] + 1, dp[i]); //dp[j] + 1是加上当前i后的最长上升子序列 dp[i]是不断更新的最长上升子序列 在所有可能中 取最大值
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }
}
