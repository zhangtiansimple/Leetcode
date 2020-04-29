package com.leetcode.medium;

public class SwapNumbers {
    //例如[5, 3]
    public int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[0] + numbers[1];//[5, 8]
        numbers[0] = numbers[1] - numbers[0];//[3, 8]
        numbers[1] = numbers[1] - numbers[0];//[3, 5]
        return numbers;
    }
}
