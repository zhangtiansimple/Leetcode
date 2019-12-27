package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    //利用二叉搜索树的性质 中序遍历的结果为有序数组
    private List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, int k) {
        //在找到第k的元素后 就不递归了
        if (list.size() == k) {
            return;
        }
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        list.add(root.val);
        inOrder(root.right, k);
    }
}
