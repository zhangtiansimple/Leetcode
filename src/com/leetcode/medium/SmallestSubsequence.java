package com.leetcode.medium;

import java.util.Stack;

/**
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入："cdadabcc"
 * 输出："adbc"
 * <p>
 * 示例 2：
 * <p>
 * 输入："abcd"
 * 输出："abcd"
 * <p>
 * 示例 3：
 * <p>
 * 输入："ecbacba"
 * 输出："eacb"
 * <p>
 * 示例 4：
 * <p>
 * 输入："leetcode"
 * 输出："letcod"
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 */

public class SmallestSubsequence {
    //贪心思想 如果字典序较大的字符在后面还有 则将其出栈
    public String smallestSubsequence(String text) {
        int len = text.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            Character c = text.charAt(i);
            if (stack.contains(text.charAt(i))) {
                continue;
            }
            //如果当前栈不为空 并且c比栈顶元素小 并且后续序列中还有c 那么就把栈顶元素出栈
            while (!stack.isEmpty() && c < stack.peek() && text.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
















