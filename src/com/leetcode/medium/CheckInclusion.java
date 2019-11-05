package com.leetcode.medium;

/**
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 *
 * 注意：
 *
 *     输入的字符串只包含小写字母
 *     两个字符串的长度都在 [1, 10,000] 之间
 *
 * */

public class CheckInclusion {
    //定长滑动窗口的运用
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] aux1 = new int[26];
        int[] aux2 = new int[26];

        //初始化s1数组
        for (int i = 0; i < s1.length(); i++) {
            aux1[s1.charAt(i) - 'a']++;
        }

        //初始化s2数组与滑动窗口初始值
        int start = 0;
        int end = start + s1.length();
        for (int i = 0; i < s2.substring(start, end).length(); i++) {
            aux2[s2.charAt(i) - 'a']++;
        }

        if (check(aux1, aux2)) {
            return true;
        }

        //更新aux2里的值 定长窗口每次向前移动一步
        while (end < s2.length()) {
            aux2[s2.charAt(end++) - 'a']++;
            aux2[s2.charAt(start++) - 'a']--;
            if (check(aux1, aux2)) {
                return true;
            }
        }

        return false;
    }

    private boolean check(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
