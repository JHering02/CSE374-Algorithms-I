
/**
 * James Hering
 * Algorithms I
 * 12 November 2023
 * 
 * A greedy choice algorithm that will recursively output the maximum profitable stock combination
 * given a list of stock prices on certain days
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int i = 1;
        int[] outcomes = new int[prices.length / 2];
        // Loop through the total possible number of outcomes
        while (i <= (prices.length / 2)) {
            outcomes[i - 1] = buyStock(prices, fee, i, 1, 0, 0);
            i++;
        }
        return maxArr(outcomes);
    }

    // Helper method to return the maximum value in an array
    private int maxArr(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int result : arr) {
            if (result > max) 
                max = result;
        }
        return max;
    }

    // Recursive helper method to process the event of buying a stock in the list
    private int buyStock(int[] prices, int f, int n, int j, int total, int next) {
        if (j > (2 * n)) 
            return total;
        int min = Integer.MAX_VALUE;
        for (int i = next; i < prices.length; i++) {
            // Only find a minimum where there's still enough n pairs past i
            if (prices[i] < min && (prices.length - (i + 1) >= (2 * n) - j)) {
                min = prices[i];
                next = i;
            }
        }
        total -= min;
        return sellStock(prices, f, n, j + 1, total, next + 1);
    }
    
    // Recursive helper method to process the event of selling a stock in the list
    private int sellStock(int[] prices, int f, int n, int j, int total, int next) {
        if (j > (2 * n)) 
            return total;
        int max = Integer.MIN_VALUE;
        for (int i = next; i < prices.length; i++) {
            // Only find a minimum where there's still enough n pairs past i
            if (prices[i] > max && (prices.length - (i + 1) >= (2 * n) - j)) {
                max = prices[i];
                next = i;
            }
        }
        total += (max - f);
        return buyStock(prices, f, n, j + 1, total, next + 1);
    }
}

