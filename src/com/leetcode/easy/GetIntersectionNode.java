package com.leetcode.easy;

import com.leetcode.base.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //A : 0 -> 9 -> 1 -> 2 -> 4
        //B : 3 -> 2 -> 4

        //进行这样的比较
        // A + B ： 0 -> 9 -> 1 -> 2 -> 4 -> 3 -> 2 -> 4
        // B + A ： 3 -> 2 -> 4 -> 0 -> 9 -> 1 -> 2 -> 4
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;

        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
