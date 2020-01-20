package com.leetcode.medium;

import com.leetcode.base.TreeNode;

public class RemoveLeafNodes {
    //使用递归 首先明确递归函数的定义 removeLeafNodes表示删除值为target的叶子节点后返回的根节点
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        //删除以root.left为根节点的所有值为target的叶子节点
        TreeNode left = removeLeafNodes(root.left, target);
        //删除以root.right为根节点的所有值为target的叶子节点
        TreeNode right = removeLeafNodes(root.right, target);

        //如果right和left都为空 那么root本身就是叶子节点了
        if (left == null && right == null && root.val == target) {
            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }
}
