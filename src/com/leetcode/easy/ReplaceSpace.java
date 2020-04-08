package com.leetcode.easy;

public class ReplaceSpace {
    public String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
