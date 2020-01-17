package com.leetcode.medium;

import com.leetcode.base.TreeNode;

public class BstFromPreorder {
    //主要是根几点的选择和区间划分的问题
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l, int r) {
        if (l > r || r >= preorder.length) {
            return null;
        }
        //先序遍历最开始一定是根节点
        TreeNode node = new TreeNode(preorder[l]);
        int subLeftEnd = l + 1;
        //根据BST的性质 寻找左区间
        while (subLeftEnd < preorder.length && preorder[subLeftEnd] < node.val) {
            subLeftEnd++;
        }
        //继续递归构造
        node.left = build(preorder, l + 1, subLeftEnd - 1);
        node.right = build(preorder, subLeftEnd, r);
        return node;
    }
}
