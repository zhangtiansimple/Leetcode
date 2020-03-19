package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    //双数可以构成回文串 如果有单数 可以在加一
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean isSingle = false;
        int res = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res += entry.getValue() / 2;
            if (entry.getValue() % 2 == 1) {
                isSingle = true;
            }
        }
        return isSingle ? (res * 2 + 1) : res * 2;
    }
}
