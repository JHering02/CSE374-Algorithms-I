import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 29 October 2023
 * 
 * A simple method that will return the maximum amount of money 
 * that can be robbed without robbing 2 adjacent houses in a list.
 */
public class HouseRob {
    public int rob(int[] houses) {
        int n = houses.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return houses[0];

        // Create a memoization table to store the maximum money robbed up to the ith house
        int[] memo = new int[n];
        memo[0] = houses[0];
        memo[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < n; i++) {
            // The key idea is to decide whether to rob the current house or not
            // If we rob the current house, we add its money to the money robbed from two houses ago
            // If we don't rob the current house, we take the maximum money robbed from the previous house
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + houses[i]);
        }

        return memo[n - 1];
    }



}
