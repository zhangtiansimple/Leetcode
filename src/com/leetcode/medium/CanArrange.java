package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CanArrange {
    public boolean canArrange(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int zero = 0;
        for (int value : arr) {
            int key = (value % k + k) % k;//保证为正数
            if (key == 0) {
                zero++; //记录可以被k整除的个数
            } else {
                list.add(key);//剩余余数放入集合
            }
        }
        if (zero % 2 != 0) { //如果可以被k整除的个数为奇数 则直接返回false
            return false;
        }
        list.sort(Comparator.comparingInt(o -> o));
        int i = 0, j = list.size() - 1;
        while (i < j) { //集合排序后首尾相加判断是否对k取余等于0
            if ((list.get(i++) + list.get(j--)) % k != 0) {
                return false;
            }
        }
        return true;
    }
}
