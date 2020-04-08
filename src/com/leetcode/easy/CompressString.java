package com.leetcode.easy;

public class CompressString {
    //按照索引 每一个字符去拼接个数
    public String compressString(String S) {
        if (S.length() == 0) return S;
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                builder.append(S.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        builder.append(S.charAt(S.length() - 1)).append(count);
        return builder.length() >= S.length() ? S : builder.toString();
    }
}
