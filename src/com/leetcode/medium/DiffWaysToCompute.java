package com.leetcode.medium;

/**
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    //分之算法的应用 将复杂问题进行拆分
    //可以类比快速排序
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                //根据符号 将字符串分成左右两部分
                String leftStr = input.substring(0, i);
                String rightStr = input.substring(i + 1);
                for (Integer left : diffWaysToCompute(leftStr)) {
                    for (Integer right : diffWaysToCompute(rightStr)) {
                        switch (input.charAt(i)) {
                            case '+' : {
                                res.add(left + right);
                                break;
                            }
                            case '-' : {
                                res.add(left - right);
                                break;
                            }
                            case '*' : {
                                res.add(left * right);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
