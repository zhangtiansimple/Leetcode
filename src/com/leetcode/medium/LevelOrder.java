package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        //使用队列来辅助遍历
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            //当前队列里的结点 其实就是一层的结点 我们只需要记录此时有几个
            //然后在下面的循环中就循环几次 因为在循环的过程中会不断的有新的子结点进入
            //这种技巧在树的相关问题中有着较为广泛的应用
            int size = nodeQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.remove();
                list.add(cur.val);
                if (cur.left != null) {
                    nodeQueue.add(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.add(cur.right);
                }
            }
            res.add(list);
        }

        return res;
    }
}
