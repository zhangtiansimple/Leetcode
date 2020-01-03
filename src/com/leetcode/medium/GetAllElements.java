package com.leetcode.medium;

import com.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements {

    //如果使用优先队列的方式或者将两个集合直接排序的方式，时间复杂度都是O(nlogn)
    //使用归并的过程，时间复杂度达到O(n)

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        return merge(list1, list2);
    }

    //BST中序遍历为有序集合
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    //归并
    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) > list2.get(j)) {
                res.add(list2.get(j++));
            } else {
                res.add(list1.get(i++));
            }
        }
        while (i < list1.size()) {
            res.add(list1.get(i++));
        }
        while (j < list2.size()) {
            res.add(list2.get(j++));
        }
        return res;
    }
}
