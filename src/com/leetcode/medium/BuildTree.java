package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.Arrays;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //前序遍历的第一个元素为根节点
        TreeNode root = new TreeNode(preorder[0]);
        //寻找根在中序遍历中的索引 划分左子树集合和右子树集合
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
}
