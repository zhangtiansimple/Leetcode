package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.*;

/**
 *
 *

 给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。

 如果可以找到返回 True，否则返回 False。



 示例 1：

 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
 输出：true
 解释：2 加 3 和为 5 。

 示例 2：

 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 输出：false



 提示：

 每棵树上最多有 5000 个节点。
 -10^9 <= target, node.val <= 10^9


 *
 * */

public class TwoSumBSTs {

    /**
     *
     * 利用二叉搜索树的性质，二叉搜索树的中序遍历结果为有序数组，使用二分查找来进行判断
     *
     * */

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        inOrder(root1, list1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (Collections.binarySearch(list1, target - node.val) >= 0) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
