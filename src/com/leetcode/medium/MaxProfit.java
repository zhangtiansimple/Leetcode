package com.leetcode.medium;
/**
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 *     你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *     卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * */
public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int len = prices.length;

        if (len == 0) {
            return 0;
        }

        //截止第i天 最后一个操作是卖时的最大收益
        int[] sell = new int[len];
        //截止第i天 最后一个操作是买时的最大收益
        int[] buy = new int[len];
        //截止第i天 最后一个操作是冷冻期时的最大收益
        int[] cool = new int[len];

        buy[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            //buy[i - 1] + prices[i] : i - 1天买入 i天卖出， sell[i - 1]： i - 1天卖出 i天无操作
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);

            //cool[i - 1] - prices[i] : i - 1天是冷冻期 i天买入， buy[i - 1] ： i - 1天卖出 i天无操作
            buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]);

            //冷冻期的前一天只可能是卖出操作
            cool[i] = sell[i - 1];
        }

        return sell[len - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int len = prices.length;

        //截止第i天 最后一个操作是买时的最大收益
        int[] buy = new int[len];
        //截止第i天 最后一个操作是卖时的最大收益
        int[] sell = new int[len];

        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < len; i++) {
            //buy[i - 1] + prices[i] : i - 1天买入 i天卖出， sell[i - 1]： i - 1天卖出 i天无操作
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            //buy[i - 1] : i - 1天买入， sell[i - 2] - prices[i] : i - 2天卖出 i天买入
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }

        return sell[len - 1];
    }
}
