package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquarefulPerms {

    //官方解题使用图的做法效率更高
    //https://leetcode-cn.com/problems/number-of-squareful-arrays/solution/zheng-fang-xing-shu-zu-de-shu-mu-by-leetcode/

    //下面是普通的回溯解法
    private int res = 0;

    public int numSquarefulPerms(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[A.length];
        Arrays.sort(A);
        trackBack(A, visited, -1,new ArrayList<>());
        return res;
    }

    private void trackBack(int[] A, boolean[] visited, int pre, List<Integer> list) {
        if (A.length == list.size()) {
            res++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            //下面的判断是核心逻辑
            //检查这个位置是否被访问过
            if (visited[i] ||
                    //检查重复元素
                    i > 0 && A[i] == A[i - 1] && visited[i - 1] ||
                    //检查是否完全平方数
                    (pre != -1 && !check(A[i], A[pre]))) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(A[i]);
                trackBack(A, visited, i,list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean check(int a, int b) {
        int num = a + b;
        int aux = (int) Math.sqrt(num);
        return aux * aux == num;
    }
}
