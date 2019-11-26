package com.leetcode.hard;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * <p>
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 */

public class NumWays {
    //这种有多种上一个状态转移到当前状态的问题 使用动态规划来解答
    public int numWays(int steps, int arrLen) {

        int mod = 1_000_000_007;

        //dp数组表示 花费i步到j的方案总数
        int[][] dp = new int[steps + 1][steps + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {
            // 注意: steps = i 时，我们最远能走到的是 i 和 arrLen-1 的较小者
            for (int j = 0; j <= Math.min(i, arrLen - 1); j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= mod;
                }
                if (j < i) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= mod;
                }
            }
        }

        return dp[steps][0];
    }
}
