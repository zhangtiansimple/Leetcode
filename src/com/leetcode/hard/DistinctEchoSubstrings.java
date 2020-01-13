package com.leetcode.hard;

/**
 *
 * 给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
 *
 *     可以写成某个字符串与其自身相连接的形式。
 *
 * 例如，abcabc 就是 abc 和它自身连接形成的。
 *
 * 示例 1：
 *
 * 输入：text = "abcabcabc"
 * 输出：3
 * 解释：3 个子字符串分别为 "abcabc" ， "bcabca" 和 "cabcab" 。
 *
 * 示例 2：
 *
 * 输入：text = "leetcodeleetcode"
 * 输出：2
 * 解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
 *
 * 提示：
 *
 *     1 <= text.length <= 2000
 *     text 只包含小写英文字母。
 *
 * */

import java.util.HashSet;
import java.util.Set;

public class DistinctEchoSubstrings {
    //题目是一道hard的题目 但是在周赛的时候 实测暴力就能过 emmm.. 可以当信心题来看
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= text.length() / 2; i++) {
            for (int j = i; j <= text.length() - i; j++) {
                if (text.substring(j, j + i).equals(text.substring(j - i, j))) {
                    set.add(text.substring(j, j + i));
                }
            }
        }
        return set.size();
    }
}
