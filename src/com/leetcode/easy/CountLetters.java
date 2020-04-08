package com.leetcode.easy;

public class CountLetters {
    //分段计算每个相同字母的子串的长度 例如aaa为3 + 2 + 1
    public int countLetters(String S) {
        int res = 0;
        char[] chs = S.toCharArray();
        for(int i = 0, j = 0; i < chs.length; i = j) {
            j = i;
            while(j < chs.length && chs[i] == chs[j]) j++;
            res += (1 + j - i) * (j - i) / 2;
        }
        return res;
    }
}
