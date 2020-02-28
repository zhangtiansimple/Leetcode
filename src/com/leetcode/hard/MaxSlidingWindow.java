package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        int max = 0, left = 0, right = k;
        //先找到第一个窗口里的最大值
        for (int i = 0; i < k; i++) {
            max = Math.max(nums[i], max);
        }
        list.add(max);
        //接着窗口往后移
        for (int i = 1; i <= nums.length - k; i++) {
            //如果新移进来的数大于最大值 则最大值为新移进来的数
            if (nums[right] > max) {
                max = nums[right];
            }
            //如果最大的数是移出去的数 就需要重新在检查一次
            else if (nums[left] == max) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    max = Math.max(nums[j], max);
                }
            }
            //如果最大的数大于新来的数 大于移出去的数 则最大数还为当前的数
            list.add(max);
            left++;
            right++;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
