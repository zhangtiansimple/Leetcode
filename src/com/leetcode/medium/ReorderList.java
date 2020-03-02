package com.leetcode.medium;

import com.leetcode.base.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        //寻找中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后半部分
        ListNode right = reverseList(slow.next);
        slow.next = null;

        //进行拼接
        ListNode left = head;
        while (right != null) {
            ListNode next = right.next;
            right.next = left.next;
            left.next = right;
            right = next;
            left = left.next.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
