package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    //分治法的应用
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    //分治函数 表示从[1, n]可以生成的二叉搜索树
    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {

            //左边区间可以生成的
            List<TreeNode> leftList = generate(start, i - 1);
            //右边区间可以生成的
            List<TreeNode> rightList = generate(i + 1, end);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
