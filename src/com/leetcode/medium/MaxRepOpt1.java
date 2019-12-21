package com.leetcode.medium;

/**
 *
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 *
 * 示例 2：
 *
 * 输入：text = "aaabaaa"
 * 输出：6
 *
 * 示例 3：
 *
 * 输入：text = "aaabbaaa"
 * 输出：4
 *
 * 示例 4：
 *
 * 输入：text = "aaaaa"
 * 输出：5
 *
 * 示例 5：
 *
 * 输入：text = "abcdef"
 * 输出：1
 *
 * 提示：
 *
 *     1 <= text.length <= 20000
 *     text 仅由小写英文字母组成。
 *
 * */

public class MaxRepOpt1 {
    public int maxRepOpt1(String text) {
        if (null == text || text.length() == 0) return 0;
        int[] aux = new int[26];
        for (int i = 0; i < text.length(); i++) {
            aux[text.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int j = 0; j < text.length() - 1; j++) {
            int count = 1;
            int index = j;
            boolean fake = true;
            char ch = text.charAt(j);
            // 要么第一次遇到不同字符，要么跟自己一样的字符
            while (j < text.length() - 1 && (fake || ch == text.charAt(j + 1))) {
                if (ch != text.charAt(j + 1)) {//遇到跟自己不一样的字符
                    fake = false;
                    index = j;
                }
                j++;
                count++;
            }
            j = index;
            // 不能比字符串中该字符的次数更大
            count = Math.min(aux[ch - 'a'], count);
            res = Math.max(count, res);
        }

        return res;
    }
}
