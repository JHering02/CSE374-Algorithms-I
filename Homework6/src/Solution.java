import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 22 October 2023
 * 
 * A program to solve the signal length problem in Homework 6 on Canvas. 
 */
class Solution {

    public int networkDelayTime(int[][] times, int N, int K) {
        // Create an array to store the minimum distances
        int[] timeToNode = new int[N];
        // Assign infinity to each possible cost
        Arrays.fill(timeToNode, Integer.MAX_VALUE);
        // Starting node is 0
        timeToNode[K - 1] = 0;
    
        // For each node, use dijkstra's algorithm to find the minimum cost
        for (int i = 0; i < N - 1; i++) {
            // Create a copy array to store the new cost
            int[] next = Arrays.copyOf(timeToNode, N);
            // Search through each flight
            for (int[] time : times) {
                int start = time[0];
                int dest = time[1];
                int weight = time[2];
                // If the total cost is less than the new cost, than replace with the cheaper cost
                if (timeToNode[start - 1] != Integer.MAX_VALUE && timeToNode[start - 1] + weight < next[dest - 1])
                    next[dest - 1] = timeToNode[start - 1] + weight;
            }
            timeToNode = next;
        }
        // Return the maximum of the shortest path to solve the problem
        int maxTime = Arrays.stream(timeToNode).max().getAsInt();
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
