package com.leetcode.easy;

import com.leetcode.base.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        //当两个链表都为空时 谁小先放谁
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        //后面还有非空节点 直接接在后面
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummyHead.next;
    }
}
