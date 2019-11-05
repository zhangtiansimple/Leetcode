package com.leetcode.medium;

/**
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 20000
 *     0 <= K <= A.length
 *     A[i] 为 0 或 1
 *
 *
 * */

public class LongestOnes {
    //题目转换为包含K个0的最长子数组
    public int longestOnes(int[] A, int K) {

        int start = 0, end = 0, res = 0;

        while (end < A.length) {
            if (A[end] == 1) { //如果是1 就继续扩展右指针 计算最大值
                end++;
                res = Math.max(res, end - start);
            } else {
                if (K > 0) { //如果还可以加入0 就继续扩展右指针 计算最大值
                    K--;
                    end++;
                    res = Math.max(res, end - start);
                } else { //不能加入0 移动左指针 如果移除的是0 就更新K值
                    if (A[start++] != 1) {
                        K++;
                    }
                }
            }
        }

        return res;
    }
}
