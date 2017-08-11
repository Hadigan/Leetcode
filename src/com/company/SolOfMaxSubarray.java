package com.company;

/**
 * Created by hadigan on 2017/8/11.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 *
 *
 */
public class SolOfMaxSubarray {
    public int maxSubArray(int[] nums) {
        int[] d = new int[nums.length];
        int max = nums[0];
        d[0] = nums[0];
        for (int i = 1;i < nums.length; i++) {
            d[i] = Integer.max(nums[i], d[i-1] + nums[i]);
            if (d[i] > max) max = d[i];
        }
        return max;
    }
}
