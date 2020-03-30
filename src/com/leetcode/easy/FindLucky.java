package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindLucky {
    public int findLucky(int[] arr) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == entry.getKey() && entry.getKey() > res) {
                res = entry.getKey();
            }
        }
        return res;
    }
}
