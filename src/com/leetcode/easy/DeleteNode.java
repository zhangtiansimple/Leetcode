package com.leetcode.easy;

import com.leetcode.base.ListNode;

public class DeleteNode {
    //虚拟头节点 删除的时候可以不考虑头节点
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
