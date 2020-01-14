package com.leetcode.medium;

public class PrevPermOpt1 {
    //贪心问题 每一步都是最优解
    public int[] prevPermOpt1(int[] A) {
        //从右往左开始找 找到第一个逆序对
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] < A[i - 1]) {
                int max = 0, index = -1;
                for (int j = i; j < A.length; j++) {
                    //找到从第一个逆序对开始 小于逆序对的最大元素 将其更换
                    if (A[j] > max && A[j] < A[i - 1]) {
                        max = A[j];
                        index = j;
                    }
                }
                if (index != -1) {
                    int temp = A[i - 1];
                    A[i - 1] = A[index];
                    A[index] = temp;
                    break;
                }
            }
        }
        return A;
    }
}
