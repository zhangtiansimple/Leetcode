package com.leetcode.medium;

public class CountNumbersWithUniqueDigits {
    /**
     *
     * 考虑有0和没有0的两种情况
     *
     * --没有0：此时为A(9, n)
     *
     * --有0：
     *
     * ----0在首位：此时等价于A(9, n - 1)
     * ----0不在首位：此时为(n-1) * A(9, n-1)
     *
     * */

    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int i = 1; i <= n; ++i) {
            res += (i - 1) * A(9, i - 1) + A(9, i);
        }
        return res;
    }

    //计算排列辅助函数
    private int A(int sum, int num) {
        int res = 1;
        for (int i = sum; i > sum - num; i--) {
            res *= i;
        }
        return res;
    }
}
