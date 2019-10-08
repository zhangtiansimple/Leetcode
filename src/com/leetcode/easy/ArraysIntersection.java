package com.leetcode.easy;

import java.util.*;

/**
 *
 *

 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。

 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。



 示例：

 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 输出: [1,5]
 解释: 只有 1 和 5 同时在这三个数组中出现.



 提示：

 1 <= arr1.length, arr2.length, arr3.length <= 1000
 1 <= arr1[i], arr2[i], arr3[i] <= 2000

 *
 *
 * */

public class ArraysIntersection {
    /**
     *
     * 解法一
     *
     * 因为是有序数组，可以使用二分查找
     *
     * */
    public List<Integer> arraysIntersection1(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        for (int arr : arr1) {
            //如果后两个数组都包含前一个数组的元素，则加入到集合里
            if(Arrays.binarySearch(arr2, arr) >= 0 && Arrays.binarySearch(arr3, arr) >= 0) {
                res.add(arr);
            }
        }
        return res;
    }


    /**
     *
     * 解法二
     *
     * 使用Map，将所有的元素都加入到Map里，如果值为3，则每个数组里都包含此元素
     *
     * */
    public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int arr : arr1) {
            if (map.containsKey(arr)) {
                map.put(arr, map.get(arr) + 1);
            } else {
                map.put(arr, 1);
            }
        }
        for (int arr : arr2) {
            if (map.containsKey(arr)) {
                map.put(arr, map.get(arr) + 1);
            } else {
                map.put(arr, 1);
            }
        }
        for (int arr : arr3) {
            if (map.containsKey(arr)) {
                map.put(arr, map.get(arr) + 1);
            } else {
                map.put(arr, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
