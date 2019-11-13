package com.leetcode.medium;

import java.util.Stack;

/**
 *
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 *
 * 示例 2：
 *
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 *
 * 示例 3：
 *
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 10^5
 *     2 <= k <= 10^4
 *     s 中只含有小写英文字母。
 *
 * */

public class RemoveDuplicates {

    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>(); //元素栈
        Stack<Character> cacheStack = new Stack<>();//缓冲栈

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == stack.peek()) { //如果当前元素和栈顶元素一定
                    cacheStack.push(s.charAt(i));
                    //从元素栈里取
                    while (cacheStack.size() < k && !stack.isEmpty() && stack.peek() == cacheStack.peek()) {
                        cacheStack.push(stack.pop());
                    }
                    //从后面的字符串里取
                    while (cacheStack.size() < k && i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                        cacheStack.push(s.charAt(i++ + 1));
                    }
                    if (cacheStack.size() == k) {
                        cacheStack.clear();
                    } else {
                        while (!cacheStack.isEmpty()) {
                            stack.push(cacheStack.pop());
                        }
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    public String removeDuplicates1(String s, int k) {
        int i = 0;
        int j = i;
        while (i != s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                if (i - j == k) {
                    s = s.substring(0, j) + s.substring(i);
                    i = j;
                    if (j == s.length()) break;
                    while (j != 0 && s.charAt(j) == s.charAt(j - 1)) {
                        j--;
                    }
                }
            } else {
                j = i;
            }
        }
        return s;
    }
}
