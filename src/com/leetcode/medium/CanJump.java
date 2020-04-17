package com.leetcode.medium;

public class CanJump {
    //贪心算法
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return true;
        //记录每个位置可以到达的最远距离
        int maxDistance = nums[0];
        for (int i = 1; i < len - 1; i++) {
            if (i <= maxDistance) {
                maxDistance = Math.max(maxDistance, nums[i]+i);
            }
        }
        return maxDistance >= len - 1;
    }
}
