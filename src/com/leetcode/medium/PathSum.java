package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 *
 * */

public class PathSum {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    //树形的dfs 基本都可以使用这个模版
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        temp.add(node.val);
        sum -= node.val;

        //是叶子节点并且sum == 0 则为结果
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(temp));
        }

        if (node.left != null) {
            dfs(node.left, sum);
        }

        if (node.right != null) {
            dfs(node.right, sum);
        }

        temp.remove(temp.size() - 1);
    }
}
