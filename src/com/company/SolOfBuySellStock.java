package com.company;

/**
 * Created by hadigan on 2017/8/11.
 */
public class SolOfBuySellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0;i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                max = Integer.max(max, prices[i] - min);
        }
        return max;
    }
}
