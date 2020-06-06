package com.leetcode.easy;

public class DiStringMatch {
    //贪心思想可以构建满足题意的序列
    //如果当前字符是I，那么从最小的元素取，反之，从最大的元素取
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int max = S.length();
        int min = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
            if (i == S.length() - 1) {
                if (S.charAt(i) == 'I') {
                    res[i + 1] = min++;
                } else {
                    res[i + 1] = max--;
                }
            }
        }
        return res;
    }
}
