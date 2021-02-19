package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CountGoodRectangles {
    //求数组中子数组最小值的最大值，并统计个数
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            int num = Math.min(rectangles[i][0], rectangles[i][1]);
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(num, max);
        }
        return map.get(max);
    }
}
