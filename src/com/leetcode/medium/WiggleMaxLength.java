package com.leetcode.medium;

public class WiggleMaxLength {
    //这道题目的标签是贪心和动态规划 其实用数学思路来解 会更简单一些
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) { //数组长度小于2 肯定是摆动序列 直接返回
            return nums.length;
        }
        int up = 1, down = 1;
        //这个循环其实就是判断连续上升或者下降的波段个数
        //可以带入一个测试用例看一下 就很清楚了
        for (int i = 1; i < nums.length; i++) {
            //如果是上升波段 就用down的值加1
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            //如果是下降波段 就用up的值加1
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
