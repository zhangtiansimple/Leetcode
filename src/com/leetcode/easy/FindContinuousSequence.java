package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence {
    //连续数列不会超过和的一半
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            int j = i;
            while (sum < target) {
                sum += j;
                j++;
            }
            if (sum == target) {
                int[] sol = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    sol[k] = k + i;
                }
                res.add(sol);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
