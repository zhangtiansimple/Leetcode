package com.leetcode.medium;

/**
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 *
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *
 * 提示：
 *
 *     1 <= tiles.length <= 7
 *     tiles 由大写英文字母组成
 *
 * */

import java.util.HashSet;
import java.util.Set;

public class NumTilePossibilities {

    private Set<String> set = new HashSet<>();

    //回溯法的基础应用
    public int numTilePossibilities(String tiles) {
        //使用一个visited数组来记录是否有访问过这个索引
        boolean[] visited = new boolean[tiles.length()];
        trackBack(tiles, visited, new StringBuilder());
        return set.size() - 1;
    }

    private void trackBack(String tiles, boolean[] visited, StringBuilder sb) {
        set.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                //如果没有访问过 就进行访问
                visited[i] = true;
                sb.append(tiles.charAt(i));
                trackBack(tiles, visited, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
