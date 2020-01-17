package com.leetcode.easy;

/**
 *
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 *
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 *
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 *
 * 注意:
 * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 *
 * */

public class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        //第一层循环找到目标单词
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                int left = i - 1, right = i + 1;
                boolean findLeft = false, findRight = false;
                //从左边开始找 找到就结束
                while (left >= 0) {
                    if (words[left].equals(word2)) {
                        findLeft = true;
                        break;
                    }
                    left--;
                }
                //从右边开始找 找到就结束
                while (right < words.length) {
                    if (words[right].equals(word2)) {
                        findRight = true;
                        break;
                    }
                    right++;
                }
                //找到了就更新最短距离
                if (findLeft) {
                    res = Math.min(res, i - left);
                }
                if (findRight) {
                    res = Math.min(res, right - i);
                }
            }
        }
        return res;
    }
}
