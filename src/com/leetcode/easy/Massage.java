package com.leetcode.easy;

public class Massage {
    //打家劫舍的小偷干起了按摩师 仍然保留了以前的习惯..
    //思路与打家劫舍一摸一样 小伙伴可以把打家劫舍一系列问题一起做一下 集中训练
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
