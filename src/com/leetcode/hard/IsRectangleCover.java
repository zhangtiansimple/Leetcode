package com.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class IsRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int n = rectangles.length;

        Set<String> set = new HashSet<>();
        int sumArea = 0;

        for (int i = 0; i < n; i++) {
            //获取四个点的坐标
            left = Math.min(left, rectangles[i][0]);
            bottom = Math.min(bottom, rectangles[i][1]);
            right = Math.max(right, rectangles[i][2]);
            top = Math.max(top, rectangles[i][3]);
            //计算总小矩形的面积
            sumArea += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);
            //分别记录小矩形的坐标
            String lt = rectangles[i][0] + " " + rectangles[i][3];
            String lb = rectangles[i][0] + " " + rectangles[i][1];
            String rt = rectangles[i][2] + " " + rectangles[i][3];
            String rb = rectangles[i][2] + " " + rectangles[i][1];
            //如果有就移除 没有就加入
            if (!set.contains(lt)) set.add(lt);
            else set.remove(lt);
            if (!set.contains(lb)) set.add(lb);
            else set.remove(lb);
            if (!set.contains(rt)) set.add(rt);
            else set.remove(rt);
            if (!set.contains(rb)) set.add(rb);
            else set.remove(rb);
        }

        //最后只剩4个大矩形坐标且面积相等即为完美矩形
        if (set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + bottom) && set.contains(right + " " + bottom) && set.contains(right + " " + top)) {
            return sumArea == (right - left) * (top - bottom);
        }
        return false;
    }

}
