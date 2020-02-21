package com.leetcode.easy;

import com.leetcode.base.TreeNode;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSameTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    //判断两棵树是否相同
    private boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t2 == null) return true;
        if(t1 == null) return false;
        if(t1.val != t2.val) return false;
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
