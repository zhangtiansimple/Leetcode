package com.leetcode.easy;

/**
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 *
 * */


import com.leetcode.base.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果两个结点都是空，那么他们是相同的
        if(p == null && q == null) {
            return true;
        }

        //如果一个结点为空，一个结点不为空，那么他们不同
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }

        //如果两个结点的值不相同，则他们不同
        if (p.val != q.val) {
            return false;
        }

        //值相同后在递归比较左结点和右结点
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
