package com.leetcode.medium;

public class WaysToChange {
    public int waysToChange(int n) {
        //背包问题
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        int i = 0;
        int j = 0;
        int[] values = {1, 5, 10, 25};
        dp[0] = 1;
        for (i = 0; i < 4; ++i) {
            for (j = values[i]; j <= n; ++j) {
                dp[j] = (dp[j] % mod + dp[j - values[i]] % mod) % mod;
            }
        }
        return dp[n];
    }
}
