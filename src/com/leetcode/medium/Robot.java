package com.leetcode.medium;

/**
 *
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 *     U: 向y轴正方向移动一格
 *     R: 向x轴正方向移动一格。
 *
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 *
 * 示例 2：
 *
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 *
 * 示例 3：
 *
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 *
 *
 *
 * 限制：
 *
 *     2 <= command的长度 <= 1000
 *     command由U，R构成，且至少有一个U，至少有一个R
 *     0 <= x <= 1e9, 0 <= y <= 1e9
 *     0 <= obstacles的长度 <= 1000
 *     obstacles[i]不为原点或者终点
 *
 * */

public class Robot {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int dx = 0, dy = 0;
        char[] cmd = command.toCharArray();
        for (char c : cmd) {
            if (c == 'U') {
                dy++;
            } else {
                dx++;
            }
        }
        int res = getTimes(cmd, x, y, dx, dy); // 拿到走到终点的次数。

        if (res == -1) return false;

        for (int[] obstacle : obstacles) {
            int cur = getTimes(cmd, obstacle[0], obstacle[1], dx, dy);
            if (cur != -1 && cur < res) return false;
        }
        return true;
    }

    // 判断是否经过该点，经过返回走的次数，没经过返回-1。
    private int getTimes(char[] cmd, int x, int y, int dx, int dy) {
        int round = Math.min(x / dx, y / dy); // 计算走到第x-1或y-1层需要多少轮
        int count = cmd.length * round;
        dx *= round;
        dy *= round;
        if (dx == x && dy == y) return count;
        for (char c : cmd) {
            if (c == 'U') dy++;
            else dx++;
            count++;
            if (dx == x && dy == y) return count; // 一旦找到，直接返回所需要的次数。
        }
        return -1;
    }
}
