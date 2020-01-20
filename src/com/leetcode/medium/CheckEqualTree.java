package com.leetcode.medium;

/**
 *
 * 给定一棵有 n 个结点的二叉树，你的任务是检查是否可以通过去掉树上的一条边将树分成两棵，且这两棵树结点之和相等。
 *
 * 样例 1:
 *
 * 输入:
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 *
 * 输出: True
 * 解释:
 *     5
 *    /
 *   10
 *
 * 和: 15
 *
 *    10
 *   /  \
 *  2    3
 *
 * 和: 15
 *
 *
 *
 * 样例 2:
 *
 * 输入:
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 *
 * 输出: False
 * 解释: 无法通过移除一条树边将这棵树划分成结点之和相等的两棵子树。
 *
 *
 *
 * 注释 :
 *
 *     树上结点的权值范围 [-100000, 100000]。
 *     1 <= n <= 10000
 *
 * */

import com.leetcode.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckEqualTree {
//    这种解法先计算出总和 然后在遍历的时候寻找和为一半的节点 找到就返回
//    public boolean checkEqualTree(TreeNode root) {
//        if (root == null) {
//            return false;
//        }
//
//        int sum = getSum(root);
//        if (sum % 2 != 0) {
//            return false;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            if (node.left != null) {
//                if (getSum(node.left) == sum / 2) {
//                    return true;
//                }
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                if (getSum(node.right) == sum / 2) {
//                    return true;
//                }
//                queue.add(node.right);
//            }
//        }
//        return false;
//    }
//
//    private int getSum(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//
//        return getSum(node.left) + getSum(node.right) + node.val;
//    }

    //使用栈来记录递归过程的和
    private Stack<Integer> stack;

    //利用后续遍历的特性和栈的结构
    public boolean checkEqualTree(TreeNode root) {
        stack = new Stack<>();
        int sum = getSum(root);
        System.out.println(stack);
        if (sum % 2 == 0) { //只有偶数才能切分
            stack.pop();
            for (int subSum : stack) {
                if (subSum == sum / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //例如例1的测试用例 存进去的结果是[10, 2, 3, 15, 30]
        stack.push(getSum(node.left) + node.val + getSum(node.right) );
        return stack.peek();
    }
}
