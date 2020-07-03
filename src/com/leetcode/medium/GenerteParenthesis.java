package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerteParenthesis {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        traceBack(n, 0, 0, new StringBuilder());
        return res;
    }

    //left代表左括号个数 right代表右括号个数
    private void traceBack(int n, int left, int right, StringBuilder sb) {
        if (left + right == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (right > left) {
            return;
        }
        //策略是先加左括号 左括号没有了在加右括号
        if (left < n) {
            sb.append("(");
            traceBack(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(")");
            traceBack(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
