package com.leetcode.medium;

public class GetMaximumGold {

    //深度优先问题
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        //遍历每个起始点，寻找最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    //递归函数 表示从（i，j）出发 所能挖到的最大黄金数
    private int dfs(int[][] grid, int i, int j) {
        //递归的终止条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        //保存当前点的值 并将grid[i][j]置为0 避免在下一次递归的时候计算回来
        int value = grid[i][j];
        grid[i][j] = 0;

        //分上下左右四个方向搜索
        int up = dfs(grid, i + 1, j);
        int down = dfs(grid, i - 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        //将grid[i][j]的值复原
        grid[i][j] = value;

        //最大值为上下左右的最大值在加value
        return Math.max(Math.max(up, down), Math.max(left, right)) + value;
    }
}
