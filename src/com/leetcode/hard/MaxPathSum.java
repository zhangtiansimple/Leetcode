package com.leetcode.hard;

import com.leetcode.base.TreeNode;

/**
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * */

public class MaxPathSum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        generatePathSum(root);
        return res;
    }

    //定义一个辅助函数 表示以当前结点为根结点的最大路径和
    private int generatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(generatePathSum(node.left), 0);
        int right = Math.max(generatePathSum(node.right), 0);

        int sum = node.val + left + right;
        res = Math.max(res, sum);

        return node.val + Math.max(left, right);
    }
}
