package com.leetcode.medium;

import com.leetcode.base.TreeNode;

public class LongestZigZag {

    private int res = 0;

    public int longestZigZag(TreeNode root) {
        helper(root, true);
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int r = helper(root.right, false);
        int l = helper(root.left, true);
        int big = Math.max(l, r);
        if (big > res) res = big;
        if (isLeft) {
            return r + 1;
        } else {
            return l + 1;
        }
    }
}
