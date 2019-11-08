package com.leetcode.easy;

/**
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {

    private List<Integer> list;
    //使用优先队列来找最小值
    private PriorityQueue<Integer> queue;

    public MinStack() {
        list = new ArrayList<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        list.add(x);
        queue.add(x);
    }

    public void pop() {
        queue.remove(list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return queue.peek();
    }
}
