package com.leetcode.easy;

import java.util.Stack;

public class CQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        stack1.add(value);
    }

    public int deleteHead() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        if(stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}
