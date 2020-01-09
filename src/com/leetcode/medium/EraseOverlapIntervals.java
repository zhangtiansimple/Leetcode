package com.leetcode.medium;

import java.util.Arrays;

public class EraseOverlapIntervals {
    //贪心思想 先按照起点排序 然后选择结尾小的区间 结尾越小 后面的越多
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int end = intervals[0][1];//end表示已经添加进去的节点尾部
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {//发生了重叠
                res++;
                end = Math.min(intervals[i][1], end);//保留小的结尾
            } else {//没有重叠则更新结尾
                end = intervals[i][1];
            }
        }
        return res;
    }
}
