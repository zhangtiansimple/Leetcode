package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinStickers {
    //利用一个map存储dp数组 key是要组成的target string 值是最优解
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (char c : stickers[i].toCharArray()) mp[i][c - 'a']++;
        dp.put("", 0);
        return helper(dp, mp, target);
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE, n = mp.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) tar[c - 'a']++;
        for (int i = 0; i < n; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0)
                    for (int k = 0; k < Math.max(0, tar[j] - mp[i][j]); k++)
                        sb.append((char) ('a' + j));
            }
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) ans = Math.min(ans, 1 + tmp);
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }
}
