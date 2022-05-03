package org.greedy;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {5, 1, 2, 4, 3};
        System.out.println("max profit: "+maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int lowPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (lowPrice > price) {
                lowPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - lowPrice);
        }
        return maxProfit;
    }
}
