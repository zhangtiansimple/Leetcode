package com.leetcode.medium;

/**
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 *
 * 注意:
 *
 *     graph 的长度范围为 [1, 100]。
 *     graph[i] 中的元素的范围为 [0, graph.length - 1]。
 *     graph[i] 不会包含 i 或者有重复的值。
 *     图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 * */

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) return false;
        int v = graph.length;
        int[] colors = new int[v];  // 0未被染色， 1黑  2白
        // 要考虑非连通图, 所以要遍历每一个结点
        for (int i = 0; i < v; i++) {
            // lastColor为0
            if (!dfs(graph, i, colors, 0)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] colors, int lastColor) {
        // 如果已经被染色 则看颜色是否相等
        if (colors[i] != 0) return colors[i] != lastColor;
        // 未被染色，染成与相邻结点不同的颜色（lastColor为0时，就染成1）
        colors[i] = lastColor == 1 ? 2 : 1;
        for (int j = 0; j < graph[i].length; j++) {
            if (!dfs(graph, graph[i][j], colors, colors[i])) return false;
        }
        return true;
    }
}
