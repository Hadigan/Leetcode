package com.company;

/**
 * Created by hadigan on 2017/8/11.
 *
 * ou are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.

 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.


 */
public class SolOfRobber {
    public int rob(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] d = new int[2][nums.length];
        d[0][0] = 0;//代表到达0的时候不偷0得多少钱
        d[1][0] = nums[0];//代表到达0的时候偷0得多少钱
        d[0][1] = nums[0];//到达1的时候不偷1得多少钱
        d[1][1] = nums[1];//到达1的时候偷1得多少钱
        for (int n = 2; n < nums.length; n++) {
            d[1][n] = Integer.max(d[0][n-2], d[1][n-2]) + nums[n];
            d[0][n] = Integer.max(d[0][n-1], d[1][n-1]);
        }
        return Integer.max(d[0][nums.length-1], d[1][nums.length-1]);
    }
}
