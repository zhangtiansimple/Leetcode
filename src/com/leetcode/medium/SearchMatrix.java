package com.leetcode.medium;

/**
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * */

public class SearchMatrix {
    //使用传统的二分查找 先找到行 在从行里使用二分查找找target
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//
//        int up = 0, down = matrix.length - 1, line = 0;
//        int mid = up + (down - up) / 2;
//
//        while (up <= down) {
//            if (mid == matrix.length - 1
//                    || mid < matrix.length - 1 && matrix[mid][0] <= target && target < matrix[mid + 1][0]) {
//                line = mid;
//                break;
//            }
//
//            if (matrix[mid][0] > target) {
//                down = mid - 1;
//            } else {
//                up = mid + 1;
//            }
//            mid = up + (down - up) / 2;
//        }
//
//        for (int i = 0; i <= line; i++) {
//            if (Arrays.binarySearch(matrix[i], target) >= 0) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    //利用这个特殊矩阵的性质 两个指针不断的去逼近
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix.length - 1;
        while (j >= 0 && i < matrix[0].length) {
            if (matrix[j][i] == target) {
                return true;
            }
            if (matrix[j][i] > target) {
                j--;
            } else if (matrix[j][i] < target) {
                i++;
            }
        }
        return false;
    }
}
