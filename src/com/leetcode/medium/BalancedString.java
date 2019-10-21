package com.leetcode.medium;

/**
 *
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 *
 *
 *
 * 给你一个这样的字符串 s，请通过「替换子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 *
 * 示例 2：
 *
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 *
 * 示例 3：
 *
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 *
 * 示例 4：
 *
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 10^5
 *     s.length 是 4 的倍数
 *     s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 *
 * */

public class BalancedString {
    //滑动窗口的应用 本题只需要窗口外每种字符的数目小于等于平均值即可
    public int balancedString(String s) {
        int[] count = new int[26];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'A']++;
        }

        int left = 0, right = 0;
        int res = len;
        int average = len / 4;

        while (right < len) {
            //滑动窗口里进来一个元素 就把count里的这个值减1
            count[s.charAt(right) - 'A']--;
            //如果四个元素都符合要求 就计算最小值
            while (left < len && count['Q' - 'A'] <= average && count['W' - 'A'] <= average && count['E' - 'A'] <= average && count['R' - 'A'] <= average) {
                res = Math.min(res, right - left + 1);
                //移动左指针 看能不能缩小范围
                count[s.charAt(left) - 'A']++;
                left++;
            }
            right++;
        }

        return res;
    }
}
