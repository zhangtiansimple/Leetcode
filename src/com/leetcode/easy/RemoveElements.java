package com.leetcode.easy;

import com.leetcode.base.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

public class RemoveElements {
    //虚拟头结点的应用
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }
}
