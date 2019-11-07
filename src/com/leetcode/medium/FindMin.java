package com.leetcode.medium;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 * */

public class FindMin {
    //二分查找解法
    public int findMin1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        //如果最后一个元素大于第一个元素 那数组是没有经过旋转的
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        //二分查找
        while (right >= left) {
            int mid = left + (right - left) / 2;

            //数组本应该是有序的 如果后一个元素小于前一个元素 那这里就是旋转点
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            //同样的道理
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) { //前半部分有序
                left = mid + 1;
            } else { //后半部分有序
                right = mid - 1;
            }
        }
        return -1;
    }

    //递归解法
    private int res = Integer.MAX_VALUE;

    public int findMin(int[] nums) {
        find(nums, 0, nums.length - 1);
        return res;
    }

    //find表示寻找在[i, j]区间里的最小值
    private void find(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = start + (end - start) / 2;
        if (nums[start] < nums[mid]) { //前半部分有序
            res = Math.min(nums[start], res);
            find(nums, mid + 1, end);
        } else if (nums[mid] < nums[end]) { //后半部分有序
            res = Math.min(nums[mid], res);
            find(nums, start, mid - 1);
        } else {
            res = Math.min(nums[start], res);
            res = Math.min(nums[end], res);
        }
    }
}
