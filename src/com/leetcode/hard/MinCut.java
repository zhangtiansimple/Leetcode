package com.leetcode.hard;

public class MinCut {

    public int minCut(String s) {
        int n = s.length();

        //dp数组表示 前i个字符至少需要分割几次
        int[] dp = new int[n + 1];
        dp[0] = -1;

        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1; //初始化 长度为 i 的子串 最多切 i - 1 次 因为单个字符肯定是回文串
            for (int j = 0; j < i; j++) {
                if (check(s.substring(j, i))) {
                    //对于所有的 j < i 如果s[j, i]是回文串 且dp[j] + 1 < dp[i] 则dp[i] = dp[j] + 1
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[n];
    }

    private boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinCut().minCut("aab"));
    }
}
