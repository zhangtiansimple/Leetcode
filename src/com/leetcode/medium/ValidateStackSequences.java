package com.leetcode;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //借用一个辅助栈
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int val : pushed) {
            stack.push(val);
            while (j < popped.length && !stack.isEmpty()
                    && stack.peek() == popped[j]) {//如果辅助栈的栈顶元素和popped[j]一样 执行同时出栈操作
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
