package com.leetcode.medium;

/**
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * */


import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    //滑动窗口的使用
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //如果没有重复的元素，则扩展右边界
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }
            //否则收缩左边界
            else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
