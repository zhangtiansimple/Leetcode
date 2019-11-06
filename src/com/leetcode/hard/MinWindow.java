package com.leetcode.hard;

public class MinWindow {
    //滑动窗口的应用
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        //题目里没有说只是大写 在提交的时候踩了不少坑..

        int[] auxT = new int[128]; //auxT用来存目标字符串
        for (int i = 0; i < t.length(); i++) {
            auxT[t.charAt(i)]++;
        }
        int[] auxS = new int[128];//auxS用来存滑动窗口里的内容
        for (int i = 0; i < t.length(); i++) {
            auxS[s.charAt(i)]++;
        }

        //start end左右指针 min记录滑动窗口最小长度 startIndex记录最小长度的起始位置
        int start = 0, end = t.length(), min = Integer.MAX_VALUE, startIndex = 0;

        while (end <= s.length()) {
            while (check(auxS, auxT)) {//如果包含 就移动左指针缩小范围
                if (end - start < min) {
                    min = end - start;
                    startIndex = start;
                }
                auxS[s.charAt(start++)]--;
            }
            if (end <= s.length() - 1) { //这里判断一下end的越界问题
                auxS[s.charAt(end++)]++;
            } else {
                break;
            }
        }
        return min != Integer.MAX_VALUE ? s.substring(startIndex, startIndex + min) : "";
    }

    private boolean check(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
