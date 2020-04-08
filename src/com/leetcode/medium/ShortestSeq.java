package com.leetcode.medium;

import java.util.*;

public class ShortestSeq {
    // 最短超串
    public int[] shortestSeq(int[] big, int[] small) {
        // 无法完成
        if (small.length > big.length) {
            return new int[0];
        }
        int[] res = new int[]{0, big.length};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : small) {
            map.put(i, -1);
        }
        int count = small.length;
        for (int i = 0; i < big.length; i++) {
            if (!map.containsKey(big[i])) continue;
            if (map.get(big[i]) == -1) count--;
            map.put(big[i], i);
            if (count <= 0) {
                int min = getMin(map);
                if (i - min < res[1] - res[0]) {
                    res[0] = min;
                    res[1] = i;
                }
            }
        }
        // 不存在
        if (count > 0) {
            return new int[0];
        }
        return res;
    }

    private int getMin(Map<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (Integer value : map.values()) {
            min = Math.min(min, value);
        }
        return min;
    }
}
