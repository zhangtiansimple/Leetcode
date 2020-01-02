package com.leetcode.hard;

import java.util.*;

/**
 * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
 * <p>
 * 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * grid =
 * [[0,0,0],
 * [1,1,0],
 * [0,0,0],
 * [0,1,1],
 * [0,0,0]],
 * k = 1
 * 输出：6
 * 解释：
 * 不消除任何障碍的最短路径是 10。
 * 消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 */

public class ShortestPath {
    public int shortestPath(int[][] grid, int k) {
        int[] dirs = new int[]{0, -1, 0, 1, 0};
        int m = grid.length, n = grid[0].length;
        int[] seen = new int[m * n];
        Arrays.fill(seen, Integer.MAX_VALUE);
        Queue<Node> q = new LinkedList<>();
        int ans = 0;
        q.add(new Node(0, 0, 0));
        seen[0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node node = q.poll();
                int x = node.x, y = node.y, z = node.z;
                if (x == m - 1 && y == n - 1) return ans;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j];
                    int ny = y + dirs[j + 1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    int ob = z + grid[x][y];
                    if (ob >= seen[nx * n + ny] || ob > k) continue;
                    seen[nx * n + ny] = ob;
                    q.add(new Node(nx, ny, ob));
                }
            }
            ans++;
        }
        return -1;
    }

    public class Node {
        int x, y, z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
