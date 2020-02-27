package com.leetcode.easy;

import com.leetcode.base.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        //如果p q都小于根节点 那么公共祖先一定在左子树中
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //反之就在右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //如果上面两个条件都不满足 此时的节点就是所求节点
        return root;
    }
}
