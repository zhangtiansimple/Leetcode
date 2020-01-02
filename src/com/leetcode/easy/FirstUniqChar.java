package com.leetcode.easy;

/**
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 */

public class FirstUniqChar {
    //题目虽然简单 但是蕴含这哈希表的思想 即如何把数据做一个映射
    public int firstUniqChar(String s) {
        int[] aux = new int[26];
        //第一遍循环 对数据出现的次数做一个统计
        for (int i = 0; i < s.length(); i++) {
            aux[s.charAt(i) - 'a']++;
        }
        //第二遍循环 只要出现1就返回
        for (int i = 0; i < s.length(); i++) {
            if (aux[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
