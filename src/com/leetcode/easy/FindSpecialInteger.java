package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 *
 * 请你找到并返回这个整数
 *
 * 示例：
 *
 * 输入：arr = [1,2,2,6,6,6,6,7,10]
 * 输出：6
 *
 * 提示：
 *     1 <= arr.length <= 10^4
 *     0 <= arr[i] <= 10^5
 * 
 * */

public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (float)arr.length / 4) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
