package com.leetcode.medium;

import java.util.Stack;

/**
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 *
 * 提示：
 *
 *     0 <= s.length <= 2000
 *     s 中只有小写英文字母和括号
 *     我们确保所有括号都是成对出现的
 *
 *
 * */

public class ReverseParentheses {
    //如果刚开始对于这道题目没有思路 可以先看看20号问题 使用栈来处理括号问题
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') { //如果是 ）则元素出栈开始反转
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();//这里是需要将（ 出栈

                //然后在将出栈的字符入栈
                String temp = sb.toString();
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
            } else { //如果不是 ）直接添加进栈就好
                stack.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
