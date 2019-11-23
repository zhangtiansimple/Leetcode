package com.leetcode.medium;

/**
 *
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length = A[0].length <= 100
 *     A[i][j] == 0 或 A[i][j] == 1
 *
 * */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    //两次dfs会超时.. dfs将第一个岛屿染色后 使用bfs寻找最小距离
    public int shortestBridge(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }

        //将第一个岛屿染成2
        for (int i = 0; i < A.length; i++) {
            boolean find = false;
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    drawColor(A, i, j);
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        int step = 0;

        Queue<int[]> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                int[] array = queue.remove();
                int i = array[0], j = array[1];

                if (i + 1 < A.length && A[i + 1][j] != 2) {
                    if (A[i + 1][j] == 1) {
                        return step;
                    }
                    A[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                }

                if (i - 1 >= 0 && A[i - 1][j] != 2) {
                    if (A[i - 1][j] == 1) {
                        return step;
                    }
                    A[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                }

                if (j + 1 < A[0].length && A[i][j + 1] != 2) {
                    if (A[i][j + 1] == 1) {
                        return step;
                    }
                    A[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                }

                if (j - 1 >= 0 && A[i][j - 1] != 2) {
                    if (A[i][j - 1] == 1) {
                        return step;
                    }
                    A[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                }
            }
            step++;
        }

        return -1;
    }

    private void drawColor(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i > A.length - 1 || j > A[0].length - 1 || A[i][j] == 2 || A[i][j] == 0) {
            return;
        }

        A[i][j] = 2;
        drawColor(A, i - 1, j);
        drawColor(A, i + 1, j);
        drawColor(A, i, j - 1);
        drawColor(A, i, j + 1);
    }
}
