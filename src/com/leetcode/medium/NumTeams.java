package com.leetcode.medium;

public class NumTeams {

    //左边比他小的人数 × 右边比他大的人数 + 左边比他大的人数 × 右边比他小的人数
    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int[] left = count(rating, 0, i, rating[i]);
            int[] right = count(rating, i, n, rating[i]);
            result += left[0] * right[1] + left[1] * right[0];
        }
        return result;
    }

    private int[] count(int[] rating, int from, int to, int key) {
        int[] results = new int[2];
        for (int i = from; i < to; ++i) {
            if (rating[i] < key) {
                ++results[0];
            } else if (rating[i] > key) {
                ++results[1];
            }
        }
        return results;
    }

//    O(n3)解法
//    public int numTeams(int[] rating) {
//        int res = 0;
//        for (int i = 0; i < rating.length; i++) {
//            for (int j = i + 1; j < rating.length; j++) {
//                if (rating[j] > rating[i]) {
//                    for (int k = j + 1; k < rating.length; k++) {
//                        if (rating[k] > rating[j]) {
//                            res++;
//                        }
//                    }
//                }
//            }
//            for (int j = i + 1; j < rating.length; j++) {
//                if (rating[j] < rating[i]) {
//                    for (int k = j + 1; k < rating.length; k++) {
//                        if (rating[k] < rating[j]) {
//                            res++;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
