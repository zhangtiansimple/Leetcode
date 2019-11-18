package com.leetcode.medium;

public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;

        //先把边界的0置为1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) && grid[i][j] == 0) {
                    dfs(grid, i, j);
                }
            }
        }

        //然后统计中间为0的区域
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) {
            return;
        }

        grid[x][y] = 1;
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
    }
}
