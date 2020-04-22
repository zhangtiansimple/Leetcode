package com.leetcode.medium;

public class CheckValidString {
    public boolean checkValidString(String s) {
        int l = 0;  //l代表左括号比较多，星号作为右括号时左括号的数量
        int h = 0;  //h代表右括号比较多，星号作为左括号时左括号的数量
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') { // ( l和h都增加
                l++;
                h++;
            } else if (tmp == ')') { // ） 如果l不为空，说明左括号比较多，则l--.同时因为h也是代表左括号的数量，所以相应的h--
                if (l > 0) {
                    l--;
                }
                h--;
            } else if (tmp == '*') { // * 如果l不为空，说明左括号比较多，星号作为右括号则l--.同时h是星号作为左括号，所以h++
                if (l > 0) {
                    l--;
                }
                h++;
            }
            if (h < 0) { // h < 0.说明将*当做左括号也不够，返回false
                return false;
            }
        }
        return l == 0; //  同时查看l == 0，如果不等于0，说明将星号视为右括号也不够左括号数量。
    }
}
