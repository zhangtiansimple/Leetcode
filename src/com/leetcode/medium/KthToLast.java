package com.leetcode.medium;

import com.leetcode.base.ListNode;

public class KthToLast {
    //使用快慢指针 快指针遍历完成之后 慢指针所指的位置就是所求结果
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
