package com.leetcode.easy;

public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean isFind = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                res++;
            }
        }
        return res;
    }
}
