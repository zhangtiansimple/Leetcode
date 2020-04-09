package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        trackBack(res, "", 0, 0, n);
        return res;
    }

    //回溯法 left统计左括号 right统计右括号
    private void trackBack(List<String> res, String s,int left, int right, int n) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            res.add(s);
        }
        if (left >= right) {
            String aux = new String(s);
            trackBack(res, aux + "(", left + 1, right, n);
            trackBack(res, aux + ")", left, right + 1, n);
        }
    }
}
