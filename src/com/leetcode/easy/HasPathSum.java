package com.leetcode.easy;

import com.leetcode.base.TreeNode;

/**
 * 
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * */

public class HasPathSum {
    //这道题目重点在于理解树的天然递归性质
    //将问题转换为 以叶子结点为根的树 是否有叶子结点减去根结点的值作为sum的路径 不断递归求解
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        //如果左右结点都为空 则为叶子结点 看看结点值是否和sum相等
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        //两边只要有一种情况满足就返回true
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
