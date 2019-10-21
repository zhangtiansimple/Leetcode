package com.leetcode.easy;

import com.leetcode.base.ListNode;

/**
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 *
 * */

public class IsPalindrome {
    //使用快慢指针找出中间节点 然后反转后一部分在进行比较
    public boolean isPalindrome(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = reverse(slow.next);

        while (cur != null) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
