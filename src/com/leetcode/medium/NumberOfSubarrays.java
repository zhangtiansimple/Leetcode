package com.leetcode.medium;

/**
 *
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 提示：
 *
 *     1 <= nums.length <= 50000
 *     1 <= nums[i] <= 10^5
 *     1 <= k <= nums.length
 * */

import java.util.HashMap;

public class NumberOfSubarrays {
    //将奇数转为1 偶数转为0 然后题目和560号题目解法一致
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ////初始化 表示和为0的从index=0开始连续子序列有1个（就是没有任何元素的空序列情况）
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //sum-(sum-k)=k
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
