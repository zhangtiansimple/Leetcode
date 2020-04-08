package com.leetcode.easy;

import java.util.Arrays;

public class TwoSum1 {
    //双指针
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                return res;
            } else if (nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }
        return res;
    }

    //二分查找
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(nums, target - nums[i]);
            if (index != i && index > 0) {
                res[0] = nums[i];
                res[1] = nums[index];
                break;
            }
        }
        return res;
    }
}
