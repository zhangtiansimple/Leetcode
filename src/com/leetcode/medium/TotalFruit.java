package com.leetcode.medium;

public class TotalFruit {
    //题目出的比较绕 可以理解为求只包含两种元素的最长连续子序列
    public int totalFruit(int[] tree) {
        int first = -1;
        int second = -1;

        int i = 0, j = 0;
        int res = 0;

        while (i < tree.length) {
            if (first == -1) {
                first = tree[i];
            }
            if (tree[i] == first) {
                i++;
            } else {
                if (second == -1) {
                    second = tree[i];
                }
                if (second == tree[i]) {
                    i++;
                } else {
                    res = Math.max(i - j, res);
                    i = ++j;
                    first = -1;
                    second = -1;
                }
            }
        }
        res = Math.max(i - j, res);

        return res;
    }
}
