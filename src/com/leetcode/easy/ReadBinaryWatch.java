package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class ReadBinaryWatch {

    //本题可以像77号问题那样当成组合问题来解答，但是那样就是medium的题目了，本题其实是一道数学问题

    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        //寻找时间区间[0:00,12:00]里有多少个1
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (getCountOne(i) + getCountOne(j) == num)
                    res.add(String.format("%d:%02d", i, j));
            }
        }
        return res;
    }

    private int getCountOne(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
