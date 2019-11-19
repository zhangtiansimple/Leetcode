package com.leetcode.medium;

/**
 *
 * 给你一个 2 行 n 列的二进制数组：
 *
 *     矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 *     第 0 行的元素之和为 upper。
 *     第 1 行的元素之和为 lower。
 *     第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 *
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 *
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < colsum.length; i++) {
            if (upper + lower < colsum[i]) {
                return new ArrayList<>();
            }
            if (colsum[i] > 2) {
                return new ArrayList<>();
            } else if (colsum[i] == 2) {//等于2的时候 需要lower upper都减1
                //upper和lower不够了 返回空集合
                if (upper <= 0 || lower <= 0) {
                    return new ArrayList<>();
                }
                list1.add(1);
                upper--;
                list2.add(1);
                lower--;
            } else if (colsum[i] == 1) {//等于1的时候 选择一个大的减1
                if (upper <= 0 && lower <= 0) {
                    return new ArrayList<>();
                }
                if (upper > lower) {
                    list1.add(1);
                    upper--;
                    list2.add(0);
                } else {
                    list1.add(0);
                    list2.add(1);
                    lower--;
                }
            } else {//等于0的时候 都加0
                list1.add(0);
                list2.add(0);
            }
        }

        //没有用完 返回空集合
        if (upper > 0 || lower > 0) {
            return new ArrayList<>();
        }

        res.add(list1);
        res.add(list2);

        return res;
    }
}
