package com.leetcode.medium;

import com.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 *
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 *
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 *
 * 提示：
 *
 *     给你的链表中可能有 1 到 1000 个节点。
 *     对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * */

public class RemoveZeroSumSublists {
    //这道题目推荐使用前缀和来做 动态规划会很复杂
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }

        //声明一个Map 键为前缀和 值为结点的引用
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode cur = head;

        while (cur != null) {
            sum += cur.val;
            if (sum == 0) { //如果和为0 则直接移除从开始到当前结点这段序列[head 到 cur]
                head = cur.next;
                cur = cur.next;
                map.clear();
            } else {
                if (map.containsKey(sum)) { //如果前后出现两个一样的和 则中间部分必为0序列 a + 0 = a
                    map.get(sum).next = cur.next;

                    //继续检查
                    cur = head;
                    map.clear();
                    sum = 0;
                } else {
                    map.put(sum, cur);
                    cur = cur.next;
                }
            }
        }

        return head;
    }
}
