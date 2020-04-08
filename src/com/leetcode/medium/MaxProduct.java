package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxProduct {
    //建立一个数组来保存以每个节点为根的总和
    private List<Integer> list = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        int sum = getSum(root);
        long res = 0;
        //这里用总和减去以每个节点为根的和来计算最大值
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, (long)(sum - list.get(i)) * list.get(i));
        }
        return (int) (res % (1e9 + 7));
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = node.val + getSum(node.left) + getSum(node.right);
        list.add(sum);
        return sum;
    }
}
