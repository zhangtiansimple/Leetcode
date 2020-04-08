package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;


//BST的中序遍历一定是有序的 可以使用这个性质来进行判定
public class IsValidBST {

    private List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) <= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
