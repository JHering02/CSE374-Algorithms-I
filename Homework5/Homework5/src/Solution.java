import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 15 October 2023
 * 
 * A program made to solve the overall minimum cost airplane problem in Homework 5 on Canvas. 
 */
class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] cost = new int[n];
        // Assign 'infiinity' to each possible cost
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        // K bounded cpsts
        for (int i = 0; i <= K; i++) {
            // Create a copy array to store the new cost
            int[] next = Arrays.copyOf(cost, n);
            // Search through each flight
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                // If the current node has a valid cost, and check for min 
                if (cost[from] != Integer.MAX_VALUE && cost[from] + price < next[to]) {
                    // Add the new cost to dst
                    next[to] = cost[from] + price;
                }
            }
            // Begin the next iteration
            cost = next;
        }
        
        // Return -1 if there was no path found, and the min cost otherwise
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}