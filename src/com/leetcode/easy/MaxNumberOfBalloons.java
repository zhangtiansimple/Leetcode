package com.leetcode.easy;

/**
 *
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 *
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "nlaebolko"
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：text = "leetcode"
 * 输出：0
 *
 *
 * 提示：
 *
 *     1 <= text.length <= 10^4
 *     text 全部由小写英文字母组成
 *
 * */

public class MaxNumberOfBalloons {
    //这道题目只需要统计b a l o n这几个字母出现的次数 求出b a n l/2 o/2的最小值即可
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        char[] textChars = text.toCharArray();
        for (char c : textChars) {
            counts[c - 'a']++;
        }
        counts['l' - 'a'] /= 2;
        counts['o' - 'a'] /= 2;

        int res = Integer.MAX_VALUE;
        for (char c : "balon".toCharArray()) {
            res = Math.min(counts[c - 'a'], res);
        }
        return res;
    }
}
