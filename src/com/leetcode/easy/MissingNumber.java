package com.leetcode.easy;

public class MissingNumber {
    //看到有序查询的问题 一定要先想想是否可以使用二分查找
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == left ? nums[left] + 1 : nums[left] - 1;
    }
}
