package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length<=1)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i=0;
        int n = intervals.length;
        while(i<n){
            int left = intervals[i][0];
            int right = intervals[i][1];
            //如果left的右区间比left的左区间大，那么合并区间的右区间就是两个右边的最大值
            while(i<n-1 && right>=intervals[i+1][0]){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            //注意一下下标的移动
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
