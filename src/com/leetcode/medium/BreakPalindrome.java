package com.leetcode.medium;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        }
        for (int i = 0; i < palindrome.length() / 2; i++) {
            //如果在前半段遇到不是a的 直接替换为a返回即可
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }
        //如果坚持到中间都没有返回 这个时候说明都是a 此时把最后一个改成b返回即可
        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}
