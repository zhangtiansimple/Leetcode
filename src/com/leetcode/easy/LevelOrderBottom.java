package com.leetcode.easy;

import com.leetcode.base.TreeNode;

import java.util.*;

public class LevelOrderBottom {
    //这道题目和树的层序遍历思想一致 只不过最后将集合顺序逆序一下就好
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();//当前层有几个结点 由于队列的长度在不断变化 使用n来做一个记录
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
