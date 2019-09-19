package com.leetcode.medium;

import com.leetcode.base.ListNode;

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //虚拟头节点在链表相关问题中的使用
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        //进位
        int carry = 0;

        //两个链表都需要计算的情况
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        //只计算l1
        while (l1 != null) {
            int val = l1.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
            l1 = l1.next;
        }

        //只计算l2
        while (l2 != null) {
            int val = l2.val + carry;
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
            l2 = l2.next;
        }

        //最后在看需不需要进位
        if(carry == 1) {
            cur.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}
