package com.leetcode.easy;

import com.leetcode.base.TreeNode;

public class DiameterOfBinaryTree {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return res;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        //在遍历的过程中不断更新最大直径
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
