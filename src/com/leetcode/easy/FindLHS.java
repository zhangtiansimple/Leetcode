package com.leetcode.easy;

/**
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 *
 * 说明: 输入的数组长度最大不超过20,000.
 *
 * */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLHS {
    //使用哈希表 对数组里的个数进行统计 如果哈希表里同时存在key与key+1 则更新最大值
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int max = 0;

        for (Integer key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(map.get(key) + map.get(key + 1), max);
            }
        }

        return max;
    }

    //滑动窗口的应用
    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int start = 0, res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[start] > 1) start++; //保证滑动窗口里满足和谐子序列
            if (nums[end] - nums[start] == 1) res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
