package com.leetcode.medium;

/**
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 *
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 *
 * 提示:
 *
 *     1 <= text1.length <= 1000
 *     1 <= text2.length <= 1000
 *     输入的字符串只含有小写英文字符。
 *
 * */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0) {
            return 0;
        }

        //dp数组表示text1[0..i]与text2[0..j]的最长公共子序列
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (text2.charAt(i) == text1.charAt(0)) {
                while (i < n) dp[0][i++] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                while (i < m) dp[i++][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {//如果text1[i] == text2[j] 那么最长公共子序列就是text1[0..i - 1]与text2[0..j - 1]的最长公共子序列在+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {//如果不等 那么就是text1[0..i-1] text2[0..j] 与 text[0..i][0..j - 1]的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
