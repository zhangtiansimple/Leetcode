package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * */


public class Combine {

    //这个类型的题目解法都是大同小异的 建议可以把排列组合问题归纳在一起去专项练习
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        trackBack(n, k, 1, new ArrayList<>());
        return res;
    }

    private void trackBack(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        //从index开始 在不到k的个数里继续寻找
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            if (!list.contains(i)) {
                list.add(i);
                trackBack(n, k, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
