package com.leetcode.medium;

/**
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    //回溯的应用
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        trackBack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    //回溯算法关键在于:不合适就退回上一步 然后通过约束条件 减少时间复杂度 做这道题之前 建议先看78号问题：子集
    private void trackBack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            tmp.add(nums[j]);
            trackBack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
