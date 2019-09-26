package com.leetcode.easy;

public class Fraction {
    //根据分式的性质从后向前递推
    public int[] fraction(int[] cont) {
        int[] res = new int[2];
        res[0] = 1;
        for(int i = cont.length - 1; i >= 0; i--){
            int temp = res[1];
            res[1] = res[0];
            res[0] = cont[i] * res[1] + temp;
        }
        return res;
    }
}
