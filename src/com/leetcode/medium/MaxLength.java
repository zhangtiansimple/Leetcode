package com.leetcode.medium;

/**
 *
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 *
 * 请返回所有可行解 s 中最长长度。
 *
 * 示例 1：
 *
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 *
 * 示例 2：
 *
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 *
 * 示例 3：
 *
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *
 *
 * 提示：
 *
 *     1 <= arr.length <= 16
 *     1 <= arr[i].length <= 26
 *     arr[i] 中只含有小写英文字母
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class MaxLength {

    private int res = 0;

    //回溯法的应用
    public int maxLength(List<String> arr) {
        if (arr.size() == 0) {
            return 0;
        }

        //含有相同字母的字符串直接跳过
        List<String> temp = new ArrayList<>();
        for (String anArr : arr) {
            if (check(anArr)) {
                temp.add(anArr);
            }
        }

        trackBack(temp, 0, new ArrayList<>());

        return res;
    }

    private void trackBack(List<String> arr, int startIndex, List<String> aux) {
        if (startIndex > arr.size() - 1) {
            return;
        }

        for (int i = startIndex; i < arr.size(); i++) {
            //如果集合里没有包含新加字符串的所有字母 就更新最大值
            if (check(aux, arr.get(i))) {
                aux.add(arr.get(i));
                StringBuilder sb = new StringBuilder();
                for (String anAux : aux) {
                    sb.append(anAux);
                }
                res = Math.max(res, sb.toString().length());
                trackBack(arr, i + 1, aux);
                aux.remove(aux.get(aux.size() - 1));
            }
        }
    }

    private boolean check(String s) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i) - 'a'] > 0) {
                return false;
            }
            temp[s.charAt(i) - 'a']++;
        }
        return true;
    }

    private boolean check(List<String> aux, String s) {
        for (String auxS : aux) {
            for (int i = 0; i < auxS.length(); i++) {
                if (s.contains(String.valueOf(auxS.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
