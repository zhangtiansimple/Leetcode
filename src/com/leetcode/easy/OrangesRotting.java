package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    //其实感觉这道题目应该是medium难度的
    //向外圈扩展的题目可以使用BFS
    public int orangesRotting(int[][] grid) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        //先把坏橘子放进来
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        //然后开始bfs
        int[] p1 = {1, -1, 0, 0}, p2 = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] aux = queue.remove();
                //检查四个方向
                for (int j = 0; j < p1.length; j++) {
                    int x = aux[0] + p1[j], y = aux[1] + p2[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            if (!queue.isEmpty()) {
                res++;
            }
        }
        //检查是否还有坏橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}
