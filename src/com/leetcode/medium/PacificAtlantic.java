package com.leetcode.medium;

import java.util.*;

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
    //思路是从海洋开始逆流 如果可以流到 就标记为1 然后检查两个海洋都可以流到的区域

    //dfs
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        //从海洋边界开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dfs(matrix, pacific, i, j, matrix[i][j]);
                }
                if (i == m - 1 || j == n - 1) {
                    dfs(matrix, atlantic, i, j, matrix[i][j]);
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int[][] aux, int i, int j, int pre) {
        //判断边界
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1
                //已经流到过了
                || aux[i][j] == 1
                //不能流动
                || matrix[i][j] < pre) {
            return;
        }

        aux[i][j] = 1;

        dfs(matrix, aux, i - 1, j, matrix[i][j]);
        dfs(matrix, aux, i + 1, j, matrix[i][j]);
        dfs(matrix, aux, i, j - 1, matrix[i][j]);
        dfs(matrix, aux, i, j + 1, matrix[i][j]);
    }


    //bfs
    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        int[][] pacificAux = new int[m][n];
        int[][] atlanticAux = new int[m][n];

        //从海洋边界开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    atlanticQueue.add(new int[]{i, j});
                }
            }
        }

        bfs(matrix, pacificAux, pacificQueue);
        bfs(matrix, atlanticAux, atlanticQueue);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificAux[i][j] == 1 && atlanticAux[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] matrix, int[][] aux , Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] array = queue.remove();
            int i = array[0];
            int j = array[1];
            //流到的区域就置为1
            aux[i][j] = 1;
            if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j] && aux[i - 1][j] != 1) {
                queue.add(new int[]{i - 1, j});
            }
            if (i + 1 < matrix.length && matrix[i][j] <= matrix[i + 1][j] && aux[i + 1][j] != 1) {
                queue.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1] && aux[i][j - 1] != 1) {
                queue.add(new int[]{i, j - 1});
            }
            if (j + 1 < matrix[0].length && matrix[i][j] <= matrix[i][j + 1] && aux[i][j + 1] != 1) {
                queue.add(new int[]{i, j + 1});
            }
        }
    }
}
