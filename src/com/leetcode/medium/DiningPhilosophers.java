package com.leetcode.medium;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    //每个叉子都是一把锁
    private ReentrantLock[] locks = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    //最多只有四个哲学家去拿叉子
    private Semaphore eatLimit = new Semaphore(4);

    public DiningPhilosophers() {

    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = (philosopher + 1) % 5; //左边叉子的编号
        int rightFork = philosopher; //右边叉子的编号

        eatLimit.acquire(); //限制人数减一

        locks[leftFork].lock(); //拿起左边的叉子
        locks[rightFork].lock();//拿起右边的叉子

        pickLeftFork.run();//拿起左边的叉子 具体执行
        pickRightFork.run();//拿起右边的叉子 具体执行

        eat.run();//吃面

        putLeftFork.run();//放下左边的叉子 具体执行
        putRightFork.run();//放下右边的叉子 具体执行

        locks[leftFork].unlock();//放下左边的叉子
        locks[rightFork].unlock();//放下右边的叉子

        eatLimit.release();//限制人数加一
    }
}
