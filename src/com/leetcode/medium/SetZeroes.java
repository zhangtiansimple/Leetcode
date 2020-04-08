package com.leetcode.medium;

import java.util.*;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        //使用两个集合来保存0值的横纵坐标
        Set<Integer> xSet = new HashSet<>(), ySet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }
        //将值为0的横纵坐标所对应的行列值置为0
        for (int x : xSet) {
            Arrays.fill(matrix[x], 0);
        }
        for (int y : ySet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
