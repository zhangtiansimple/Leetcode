package com.leetcode.medium;

public class NumOfSubarrays {
    //定长滑动窗口的应用
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0, sum = 0;
        int left = 0, right = left + k - 1;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        if ((float)sum / k >= threshold) {
            res++;
        }
        //在滑动过程中，每次减去最左边的值，加上最右边下一位的值
        while (right < arr.length - 1) {
            sum -= arr[left++];
            sum += arr[++right];
            if ((float)sum / k >= threshold) {
                res++;
            }
        }
        return res;
    }
}
