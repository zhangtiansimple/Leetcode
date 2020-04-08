package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.*;

public class LevelOrderIII {
    //二叉树的层序遍历 每一层按照正反的顺序单独放进集合就好
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOrder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!isOrder) {
                Collections.reverse(list);
            }
            isOrder = !isOrder;
            res.add(list);

        }
        return res;
    }
}
