package com.leetcode.medium;

import java.util.Arrays;

public class SmallestDifference {
    //注意int的溢出问题
    public int smallestDifference(int[] a, int[] b) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            res = (int) Math.min(Math.abs((long) a[i] - (long) b[j]), res);
            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
