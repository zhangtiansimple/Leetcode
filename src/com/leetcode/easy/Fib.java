package com.leetcode.easy;

import java.util.Arrays;

public class Fib {
//    public int fib(int n) {
//        if(n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return (int) ((fib(n - 1) + fib(n - 2)) % (1e9 + 7));
//    }

//    private long[] memo;
//
//    public int fib(int n) {
//        memo = new long[n + 1];
//        Arrays.fill(memo, -1);
//        return (int) getFib(n);
//    }
//
//    private long getFib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if(memo[n] == -1) {
//            memo[n] = (long) ((getFib(n - 1) + getFib(n -2)) % (1e9 + 7));
//        }
//        return memo[n];
//    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (long) ((dp[i - 1] + dp[i - 2]) % (1e9 + 7));
        }
        return (int) dp[n];
    }
}
