package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
 *
 * 返回经过一些翻转后，行上所有值都相等的最大行数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 *
 * 示例 2：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 *
 * 示例 3：
 *
 * 输入：[[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 *
 *
 *
 * 提示：
 *
 *     1 <= matrix.length <= 300
 *     1 <= matrix[i].length <= 300
 *     所有 matrix[i].length 都相等
 *     matrix[i][j] 为 0 或 1
 *
 * */

public class MaxEqualRowsAfterFlips {
    /**
     *
     * 两行数字，经过对一些列的反转，最后都达到这一行的值的相同。那么这两行数字的关系有以下两种情况：
     * 1.两行的数字都相同
     * 2.两行的数字的值都是相反的
     *
     * */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][0] == 0 ? matrix[i][j] : matrix[i][j] == 1 ? 0 : 1);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int v : map.values()) {
            res = Math.max(v, res);
        }
        return res;
    }
}
