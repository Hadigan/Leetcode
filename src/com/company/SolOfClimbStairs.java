package com.company;

/**
 * Created by hadigan on 2017/8/11.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 * Note: Given n will be a positive integer.
 */
public class SolOfClimbStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int oneBefore = 1;
        int twoBefore  = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = oneBefore;
            oneBefore = oneBefore + twoBefore;
            twoBefore = tmp;
        }
        return oneBefore;
    }
}
