package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder {
    //和课程表1解法一致 多使用一个数组来存储遍历过程中的节点即可
    //课程表1解法：https://github.com/zhangtiansimple/Leetcode/blob/master/src/com/leetcode/medium/CanFinish.java
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.remove();
            list.add(node);
            numCourses--;

            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != node) {
                    continue;
                }
                if (--inDegrees[prerequisite[0]] == 0) {
                    queue.add(prerequisite[0]);
                }
            }
        }

        if (numCourses == 0) {
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        } else {
            return new int[]{};
        }
    }
}
