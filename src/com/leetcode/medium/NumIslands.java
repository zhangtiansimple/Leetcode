package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */

public class NumIslands {
    //深度优先 遇到1 遍历所有与其相邻的为1的区域 置为0 即为一个岛屿
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    //广度优先
    public int numIslands1(char[][] grid) {
        int res = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    queue.add(new int[]{i, j});
                    grid[i][j] = '2';
                    while (!queue.isEmpty()) {
                        int[] aux = queue.remove();
                        int x = aux[0];
                        int y = aux[1];
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.add(new int[]{x - 1, y});
                            grid[x - 1][y] = '2';
                        }
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            queue.add(new int[]{x + 1, y});
                            grid[x + 1][y] = '2';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.add(new int[]{x, y - 1});
                            grid[x][y - 1] = '2';
                        }
                        if (y + 1 < grid[i].length && grid[x][y + 1] == '1') {
                            queue.add(new int[]{x, y + 1});
                            grid[x][y + 1] = '2';
                        }
                    }
                }
            }
        }

        return res;
    }
}
















