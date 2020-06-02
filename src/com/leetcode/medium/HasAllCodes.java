package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {
    //定长滑动窗口的应用
    public boolean hasAllCodes(String s, int k) {
        int left = 0, right = k;
        int len = s.length();
        Set<String> set = new HashSet<>();
        while (right <= len) {
            set.add(s.substring(left, right));
            left++;
            right++;
        }
        return set.size() == Math.pow(2, k);
    }
}
