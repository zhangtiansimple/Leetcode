package com.leetcode.medium;

/**
 *
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 *
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 *
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 * 提示：
 *
 *     1 <= nums.length <= 4 * 10^4
 *     1 <= nums[i] <= 10^4
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        //记录余数为1的数
        List<Integer> modOne = new ArrayList<>();
        //记录余数为2的数
        List<Integer> modTwo = new ArrayList<>();

        int sum = 0;

        for (int num : nums) {
            if (num % 3 == 1){
                modOne.add(num);
            }
            if (num % 3 == 2) {
                modTwo.add(num);
            }
            sum += num;
        }

        //把小的放在前面删除
        Collections.sort(modOne);
        Collections.sort(modTwo);

        int key = sum % 3, res = 0;

        if (key == 0) {
            return sum;
        }


        if (key == 1){
            //删除1个余数为1的数或者两个余数为2的数
            if (modTwo.size() >= 2) {
                res = Math.max(res, sum - modTwo.get(0) - modTwo.get(1));
            }
            if (modOne.size() >= 1) {
                res = Math.max(res, sum - modOne.get(0));
            }
        } else if (key == 2) {
            //删除一个余数为2的数或者两个余数为1的数
            if (modTwo.size() >= 1) {
                res = Math.max(res, sum - modTwo.get(0));
            }
            if (modOne.size() >= 2) {
                res = Math.max(res, sum - modOne.get(0) - modOne.get(1));
            }
        }

        return res;
    }
}
