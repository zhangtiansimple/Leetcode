package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class VerifyPostorder {
    //使用递归
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        //后续遍历 最后一个元素是根节点
        int root = postorder[postorder.length - 1];
        //两个集合分别保存左右子树的值
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int rightIndex = -1;
        for (int i = 0; i < postorder.length - 1; i++) {
            //遇到比跟节点大的 就到了右子树序列
            if (postorder[i] > root) {
                rightIndex = i;
                break;
            }
            left.add(postorder[i]);
        }
        if(rightIndex != -1) {
            for (int i = rightIndex; i < postorder.length - 1; i++) {
                //如果右子树序列中出现比root小的 直接返回false
                if (postorder[i] < root) {
                    return false;
                }
                right.add(postorder[i]);
            }
        }
        int[] leftArray = new int[left.size()];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = left.get(i);
        }
        int[] rightArray = new int[right.size()];
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = right.get(i);
        }
        //递归检查左右子树
        return verifyPostorder(leftArray) && verifyPostorder(rightArray);
    }

    public boolean verifyPostorder1(int[] postorder) {
        // 单调栈使用，单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        int pervElem = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length - 1;i>=0;i--){
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > pervElem){
                return false;
            }
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                pervElem = stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}
