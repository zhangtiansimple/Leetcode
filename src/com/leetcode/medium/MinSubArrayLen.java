package com.leetcode.medium;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */

public class MinSubArrayLen {
    //滑动窗口的应用
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, res = Integer.MAX_VALUE;

        while (end <= nums.length) {
            while (sum >= s) {
                res = Math.min(res, end - start);
                sum -= nums[start++];
            }
            if (end < nums.length) {
                sum += nums[end++];
            } else {
                break;
            }

        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
