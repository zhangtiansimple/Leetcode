package com.leetcode.medium;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */


import com.leetcode.base.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        //使用队列来辅助遍历
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        //是否正序
        boolean isOrder = true;

        while (!nodeQueue.isEmpty()) {
            //这个问题的处理方法其实和102号问题一样，只不过一层是正序一层是倒序
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
            //在这里处理顺序 也可以在上面的循环中 根据isOrder的值来选择下标从0开始还是从size - 1开始 效率更高 没有reverse的操作
            if (isOrder) {
                res.add(list);
            } else {
                Collections.reverse(list);
                res.add(list);
            }
            isOrder = !isOrder;
        }

        return res;
    }
}
