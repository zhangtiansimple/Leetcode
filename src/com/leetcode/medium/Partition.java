package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * */

public class Partition {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return res;
        }
        trackBack(s, 0, new ArrayList<>());
        return res;
    }

    private void trackBack(String s, int startIndex, List<String> list) {
        if (startIndex > s.length() - 1) {
            res.add(new ArrayList<>(list));
            return;
        }

        //从startIndex开始 依次截取长度为1，2，3。。。的字符串进行递归
        for (int i = 1; i < s.length() - startIndex + 1; i++) {
            if (check(s.substring(startIndex, startIndex + i))) {
                list.add(s.substring(startIndex, startIndex + i));
                trackBack(s, startIndex + i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
