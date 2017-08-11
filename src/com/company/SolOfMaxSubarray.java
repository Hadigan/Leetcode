package com.company;

/**
 * Created by hadigan on 2017/8/11.
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
