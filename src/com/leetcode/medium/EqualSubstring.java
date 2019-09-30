package com.leetcode.medium;
/**
 *
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 *
 * 示例 2：
 *
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *
 * 示例 3：
 *
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length, t.length <= 10^5
 *     0 <= maxCost <= 10^6
 *     s 和 t 都只含小写英文字母。
 *
 * */

public class EqualSubstring {
    //滑动窗口的运用
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost = new int[s.length()];

        //将差值转换为cost数组 变为最长连续子数组的问题
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int start = 0, end = 0, sum = 0, res = 0;

        while (end < s.length()) {
            if (sum + cost[end] > maxCost) { //如果sum加上当前位的cost已经比maxCost大了 则左指针前进一位 并且从sum中减去
                sum -= cost[start++];
            } else {//如果没有大于maxCost 则更新res并且继续向后扩张
                res = Math.max(res, end - start + 1);
                sum += cost[end++];
            }
        }

        return res;
    }
}
