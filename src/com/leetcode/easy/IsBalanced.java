package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 false 。
 *
 *
 * */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //层序遍历二叉树
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            //如果当前结点的左右子树高度之差大于1 则直接返回false
            if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return true;
    }

    //返回当前结点的最大高度
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
