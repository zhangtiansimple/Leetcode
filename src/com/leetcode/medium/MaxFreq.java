package com.leetcode.medium;

/**
 *
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 *
 *     子串中不同字母的数目必须小于等于 maxLetters 。
 *     子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 *
 * 示例 1：
 *
 * 输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * 输出：2
 * 解释：子串 "aab" 在原字符串中出现了 2 次。
 * 它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
 *
 * 示例 2：
 *
 * 输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * 输出：2
 * 解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
 *
 * 示例 3：
 *
 * 输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * 输出：3
 *
 * 示例 4：
 *
 * 输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * 输出：0
 *
 * 提示：
 *
 *     1 <= s.length <= 10^5
 *     1 <= maxLetters <= 26
 *     1 <= minSize <= maxSize <= min(26, s.length)
 *     s 只包含小写英文字母。
 *
 * */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxFreq {
    //定长滑动窗口
    //如果长的重复 那么短的必定重复 所以不需要使用maxSize
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //left right滑动窗口的下标
        int res = 0, left = 0, right = left + minSize - 1;
        //map用来记录滑动过程中的字符串
        Map<String, Integer> map = new HashMap<>();
        while (right < s.length()) {
            String str = s.substring(left, right + 1);
            //如果满足题意 就加到map里
            if (check(str) <= maxLetters) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            right++;
            left++;
        }
        for (int val : map.values()) {
            res = Math.max(val, res);
        }
        return res;
    }

    private int check(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
