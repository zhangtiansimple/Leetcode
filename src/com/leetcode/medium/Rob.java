package com.leetcode.medium;

/**
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * */
public class Rob {
    //可以直接调用198号问题的解答方式 将区间分为[0..n - 1]和[1..n]
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        System.arraycopy(nums, 1, nums2, 0, nums.length - 1);

        return Math.max(tryRob(nums1), tryRob(nums2));
    }

    public int tryRob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        //dp[i]表示 最后一家偷i家所得的最高金额
        int[] dp = new int[nums.length];
        //dp[0] 只偷0家的 最大自然是num[0]
        dp[0] = nums[0];
        //dp[1] 如果nums[0] > nums[1] 那么偷第一家利润大 第二家不偷 反之偷第二家
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            //dp[i - 1]表示前一家作案 这家不做案的最大金额 dp[i - 2] + nums[i]表示前前一家作案 这家作案的最大金额
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}













