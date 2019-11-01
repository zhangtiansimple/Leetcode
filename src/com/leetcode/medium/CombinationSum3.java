package com.leetcode.medium;

/**
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 *     所有数字都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    //回溯法的应用 与39号问题 40号问题解法一致
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        trackBack(1, k, n, res, new ArrayList<>());
        return res;
    }

    private void trackBack(int index, int k, int n, List<List<Integer>> res, List<Integer> temp) {
        if (k < 0) {
            return;
        }
        if (n < 0) {
            return;
        }
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < 10; i++) {
            temp.add(i);
            k--;
            trackBack(i + 1, k, n - i, res, temp);
            k++;
            temp.remove(temp.size() - 1);
        }
    }
}
