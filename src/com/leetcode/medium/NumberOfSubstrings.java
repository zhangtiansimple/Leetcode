package com.leetcode.medium;

public class NumberOfSubstrings {
    //滑动窗口的应用
    //初版
    public int numberOfSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int left = 0, right = 2, n = s.length(), res = 0;
        while (left < n - 2) {
            String temp = s.substring(left, right + 1);
            if (temp.contains("a") && temp.contains("b") && temp.contains("c")) {
                //如果窗口内包含有元素abc 则后面所有的字符串都会包含abc
                //所以 res += n - 右边界
                res += n - right;
                left++;
            } else {
                right++;
                if (right == n) {
                    break;
                }
            }
        }
        return res;
    }

    //改进版
    public int numberOfSubstrings1(String s) {
        int[] aux = new int[3];
        int res = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            aux[s.charAt(right) - 'a']++;
            while (aux[0] != 0 && aux[1] != 0 && aux[2] != 0) {
                res += s.length() - right;
                aux[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}
