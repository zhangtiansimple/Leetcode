package com.leetcode.medium;

public class MatrixScore {
    //只存在翻转或者不翻转的情况
    public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length, n = A[0].length;

        //对于行 就看最高位是否为1
        for (int i = 0; i < m; i++) {
            //如果最高位不是1 就转换当前行
            if (A[i][0] != 1) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        //对于列 就看当前列1多还是0多
        for (int i = n - 1; i >= 0; i--) {
            int one = 0, zero = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }
            //1多就不翻转 0多就翻转
            if (one < zero) {
                for (int j = 0; j < m; j++) {
                    A[j][i] = 1 - A[j][i];
                }
            }
        }

        int res = 0;

        //统计结果
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(A[i][j]);
            }
            res += Integer.parseInt(sb.toString(),2);
        }

        return res;
    }
}
