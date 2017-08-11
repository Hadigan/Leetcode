package com.company;

/**
 * Created by hadigan on 2017/8/11.
 */
public class SolOfNumArray {
    int[][] d;
    int[] nums2;
    public SolOfNumArray(int[] nums) {
        d = new int[nums.length][nums.length];
        nums2 = nums;
    }

    public int sumRange(int i, int j) {
        int tmpIndex = j;
        while(tmpIndex > i) {
            if (d[i][tmpIndex] != 0)
                break;
            tmpIndex++;
        }
        for(; tmpIndex < j; tmpIndex++) {
            d[i][tmpIndex+1] = d[i][tmpIndex] + nums2[tmpIndex+1];
        }
        return d[i][j];
    }
}
