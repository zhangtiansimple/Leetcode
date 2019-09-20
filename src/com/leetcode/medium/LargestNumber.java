package com.leetcode.medium;

/**
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumber {
    //自定义一种排序方式 比较 s1 + s2 和 s2 + s1
    //例如10 2， 连接起来分别是210 和 102 将大的放在高位
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        //先转为String
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        //使用优先队列排序
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;

            return str2.compareTo(str1);
        });

        priorityQueue.addAll(list);

        StringBuilder sb = new StringBuilder();

        //构建结果
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.remove());
        }

        if(sb.toString().charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
