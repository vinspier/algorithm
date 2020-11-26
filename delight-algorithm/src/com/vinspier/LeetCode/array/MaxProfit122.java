package com.vinspier.LeetCode.array;

/**
 * leetcode 122 股票最佳时机
 *
 * @author: vinspier
 * @date: 2020/11/26 16:26
 */
public class MaxProfit122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            // 第二天涨的时候 前一天就买入
            // 第二天降的时候 前一天就卖出
            if (prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}
