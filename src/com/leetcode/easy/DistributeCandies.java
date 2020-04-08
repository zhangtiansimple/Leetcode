package com.leetcode.easy;

public class DistributeCandies {
    //维护两个值 一个记录当前位置 一个记录当前糖果数 然后按照顺序放置即可
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0, candie = 1;
        while (candies > 0) {
            index = index % num_people;
            if (candie > candies) { //如果当前糖果不够了
                res[index] = candies + res[index];
                break;
            }
            res[index] = candie + res[index];
            index++;
            candies = candies - candie++;
        }
        return res;
    }
}
