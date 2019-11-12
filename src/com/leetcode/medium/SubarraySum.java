package com.leetcode.medium;

/**
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 *
 *     数组的长度为 [1, 20,000]。
 *     数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * */

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    //使用哈希表
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }


    //使用前缀和 aux表示累计到i的前缀和 aux[j] - aux[i] + nums[i] 表示i 与 j之间的和
    public int subarraySum1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] aux = new int[len];
        int res = 0;
        aux[0] = nums[0];
        if (aux[0] == k) {
            res++;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] == k) {
                res++;
            }
            aux[i] = nums[i] + aux[i - 1];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (aux[j] - aux[i] + nums[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
