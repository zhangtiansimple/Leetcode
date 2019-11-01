package com.leetcode.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 */

public class CombinationSum2 {
    //回溯法的应用 与组合总和1的解法一样 只需要去重即可
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        trackBack(0, target, candidates, res, new ArrayList<>());
        return res;
    }

    private void trackBack(int index, int target, int[] candidates, List<List<Integer>> res, List<Integer> tmp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            tmp.add(candidates[i]);
            trackBack(i + 1, target - candidates[i], candidates, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}


















