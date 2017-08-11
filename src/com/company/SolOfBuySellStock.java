package com.company;

/**
 * Created by hadigan on 2017/8/11.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit
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
