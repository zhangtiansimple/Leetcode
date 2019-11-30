package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SplitIntoFibonacci {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        trackBack(S, 0, new ArrayList<>());
        return res;
    }

    private void trackBack(String s, int index, List<Integer> list) {

        //题目可能有多种组合
        if (res.size() > 0) {
            return;
        }

        //集合里元素少于两个的时候 直接加进去
        if (list.size() > 2) {
            //如果所有字符都使用了并且满足斐波那契数列的性质
            if (checkStr(s, list) && checkIsFib(list)) {
                res.addAll(list);
                return;
            }

            //如果剩下的字符串不是以集合里最后两个数的和开头 直接返回
            if (!s.substring(index).startsWith(String.valueOf(list.get(list.size() - 1) + list.get(list.size() - 2)))) {
                return;
            }
        }

        for (int i = 0; i <= s.length() - index; i++) {
            if (index + i <= s.length() && !s.substring(index, index + i).equals("")) {
                String str = s.substring(index, index + i);
                //判断整型是否溢出
                if (str.length() > 10 || Long.valueOf(str) > Integer.MAX_VALUE) {
                    break;
                }
                list.add(Integer.valueOf(str));
                trackBack(s, index + i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean checkStr(String s, List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString().equals(s);
    }

    private boolean checkIsFib(List<Integer> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) + list.get(i + 1) != list.get(i + 2)) {
                return false;
            }
        }
        return true;
    }
}
