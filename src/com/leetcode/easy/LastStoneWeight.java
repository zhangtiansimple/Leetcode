package com.leetcode.easy;

import java.util.PriorityQueue;

/**
 *
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 *     如果 x == y，那么两块石头都会被完全粉碎；
 *     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 * 提示：
 *
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 1000
 *
 * */

public class LastStoneWeight {
    //使用优先队列 保障每次取石头的时候都可以取到最大的
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int a = queue.remove();
            int b = queue.remove();
            if (a != b) {
                queue.add(a - b);
            }
        }
        return queue.size() == 0 ? 0 :queue.remove();
    }
}
