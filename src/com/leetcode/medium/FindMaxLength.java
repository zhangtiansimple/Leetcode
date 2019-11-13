package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 示例 2:
 *
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 *
 *
 * 注意: 给定的二进制数组的长度不会超过50000。
 *
 * */

public class FindMaxLength {
    //将原数组的0全部变为-1 则问题等价于“元素值总和为0的连续数组” 接着遍历数组 记录当前的前缀和的值
    //若该前缀和的值已出现过 则说明标记中的下标到当前扫描的下标的这段数组的总和值是为0的
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 && i > res) {
                res = i + 1;
            }
            if (map.containsKey(sum)) {
                res = Math.max(i - map.get(sum), res);
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}