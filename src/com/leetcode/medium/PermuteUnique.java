package com.leetcode.medium;

/**
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * */

import java.util.*;

public class PermuteUnique {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        //先排序 方便后面去重
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        trackBack(nums, visited, new ArrayList<>());
        return res;
    }

    private void trackBack(int[] nums, boolean[] visited, List<Integer> list) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                //这个判定为关键条件 如果这个元素和上个元素一样 并且上个元素已经被使用了 则跳过 去重的判定
                //例如测试用例[1,1,2] 第一次会先得到index = 0开始的1 1 2 在index = 1开始的 1 1 2时 利用下面的条件判定直接跳过了
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                trackBack(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }


    //使用set去重 解法和全排列一致 不过效率上会有影响
//    private Set<List<Integer>> set = new HashSet<>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        if (nums.length == 0) {
//            return new ArrayList<>();
//        }
//        boolean[] visited = new boolean[nums.length];
//        trackBack(nums, visited, new ArrayList<>());
//        return new ArrayList<>(set);
//    }
//
//    private void trackBack(int[] nums, boolean[] visited, List<Integer> list) {
//        if (list.size() == nums.length) {
//            set.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                list.add(nums[i]);
//                trackBack(nums, visited, list);
//                list.remove(list.size() - 1);
//                visited[i] = false;
//            }
//        }
//    }
}
