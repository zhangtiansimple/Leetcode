package com.leetcode.medium;

public class AngleClock {
    public double angleClock(int hour, int minutes) {
        //分针和时针的夹角为5.5 * minutes - 30 * hour
        double angle = Math.abs(minutes * 5.5 - hour * 30);
        //如果是大于180°的角 则用360去减
        return angle > 180 ? (360 - angle) : angle;
    }
}
