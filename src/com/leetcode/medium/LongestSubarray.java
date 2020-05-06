package com.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        //维护一个最大堆和最小堆
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            minQueue.add(nums[right]);
            maxQueue.add(nums[right++]);
            while (maxQueue.peek() - minQueue.peek() > limit) {
                maxQueue.remove(nums[left]);
                minQueue.remove(nums[left++]);
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}
