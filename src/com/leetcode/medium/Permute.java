package com.leetcode.medium;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class Permute {
    //回溯法 与组合问题解题思路都是一致的 主要明确在回溯过程中的限定条件即可
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        trackBack(nums, res, new ArrayList<>());
        return res;
    }

    private void trackBack(int[] nums, List<List<Integer>> res, List<Integer> aux) {
        if (aux.size() == nums.length) {
            res.add(new ArrayList<>(aux));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!aux.contains(nums[i])) {
                aux.add(nums[i]);
                trackBack(nums, res, aux);
                aux.remove(aux.size() - 1);
            }
        }
    }
}



















