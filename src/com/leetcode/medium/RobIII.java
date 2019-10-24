package com.leetcode.medium;

import com.leetcode.base.TreeNode;

public class RobIII {
    public int rob(TreeNode root) {
        return tryRob(root, 0);
    }

    //表示偷取root节点所能获取的最大收益
    private int tryRob(TreeNode root, int coins) {
        if (root == null) {
            return coins;
        }

        if (root.left == null && root.right == null) {
            return coins + root.val;
        }

        //偷取左节点取得的最大收益
        int left = tryRob(root.left, coins);
        //偷取右节点取得的最大收益
        int right = tryRob(root.right, coins);

        //偷取当前节点所能取得的最大收益
        int cur = coins + root.val
                + (root.left == null ? 0 : tryRob(root.left.left, coins) + tryRob(root.left.right, coins))
                + (root.right == null ? 0 : tryRob(root.right.left, coins) + tryRob(root.right.right, coins));

        return Math.max(right + left, cur);
    }
}
