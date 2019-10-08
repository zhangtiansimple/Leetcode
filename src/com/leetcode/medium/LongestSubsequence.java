package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 示例 2：
 *
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 示例 3：
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 *
 *
 * 提示：
 *
 *     1 <= arr.length <= 10^5
 *     -10^4 <= arr[i], difference <= 10^4
 *
 *
 * */


public class LongestSubsequence {
    /**
     * 这道题目为最长上升子序列的简化版本，因为公差固定，所以只需要记录以当前数字为末尾的序列长度，不需要像最长上升子序列那样在循环里执行第二次检索
     * */
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>(); //Map表示以数字为结尾的序列的长度
        int res = 1;
        for (int a : arr) {
            int temp = map.getOrDefault(a - difference, 0) + 1;
            map.put(a, temp);
            res = Math.max(res, temp);
        }
        return res;
    }
}
