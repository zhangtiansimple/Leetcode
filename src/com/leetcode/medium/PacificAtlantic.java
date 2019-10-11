package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *
 * 提示：
 *
 *     输出坐标的顺序不重要
 *     m 和 n 都小于150
 *
 * 示例：
 *
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * */

public class PacificAtlantic {
    //本题采用逆向思考的方式 从边界开始 找水流可以倒着流过去的位置
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) { //如果i或者j为0 表示太平洋可以逆向到达的位置
                    dfs(matrix, pacific, i, j, matrix[i][j]);
                }
                if (i == m - 1 || j == n - 1) { //表示大西洋可以逆向到达的位置
                    dfs(matrix, atlantic, i, j, matrix[i][j]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int[][] aux, int i, int j, int pre) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 //边界判断
                || aux[i][j] == 1 //已经遍历过
                || matrix[i][j] < pre) { //流不过去
            return;
        }

        aux[i][j] = 1;

        dfs(matrix, aux, i - 1, j, matrix[i][j]);
        dfs(matrix, aux, i + 1, j, matrix[i][j]);
        dfs(matrix, aux, i, j - 1, matrix[i][j]);
        dfs(matrix, aux, i, j + 1, matrix[i][j]);
    }
}
