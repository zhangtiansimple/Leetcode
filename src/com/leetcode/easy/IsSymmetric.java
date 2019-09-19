package com.leetcode.easy;

import com.leetcode.base.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //以镜像的方式检查这棵树
        return check(root, root);
    }

    private boolean check(TreeNode node1, TreeNode node2) {
        //如果都是空 则是镜像的
        if (node1 == null && node2 == null) {
            return true;
        }

        //如果一个为空一个不为空 则不是镜像的
        if (node1 == null || node2 == null) {
            return false;
        }

        //这里检查两个结点的值 以及用镜像的方式检查结点 即结点1的右子树和结点2的左子树 结点1的左子树和结点二的右子树
        return node1.val == node2.val && check(node1.right, node2.left) && check(node1.left, node2.right);
    }
}
