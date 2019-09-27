package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 *
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * */

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length; //数组的长度
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();//单词的长度

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) { //将所有单词存在Map中
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word , 1);
            }
        }

        //s.length() - wordNum * wordLen + 1的下标为最后一个长度为wordNum * wordLen的起始坐标
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //这个map存当前扫描的字符串含有的单词
            Map<String, Integer> curMap = new HashMap<>();
            //表示已经有了几个单词
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                //取出当前位置的单词
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (map.containsKey(word)) {
                    if (curMap.containsKey(word)) {
                        curMap.put(word, curMap.get(word) + 1);
                    } else {
                        curMap.put(word, 1);
                    }
                    //判断当前单词的value和map中该单词的value
                    if (curMap.get(word) > map.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) { //如果每个子串都符合 没有提前break 则num == wordNum
                res.add(i);
            }
        }
        return res;
    }
}
