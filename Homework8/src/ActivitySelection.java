import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 1 November 2023
 * 
 * A greedy choice algorithm that will select the maximum activity that's able to be performed by a single person.
 * This assumes that a person can only work on on one activity at a time.
 */
public class ActivitySelection {

    int[] findMaxActivities(int[] startTimes, int[] finishTimes) {
        // Store an array with the optimal activities
        int[] optimals = new int[startTimes.length];
        int currMax = Integer.MIN_VALUE, i = 0, count = 0;
        while (i < startTimes.length) {
            // If the start time is greater than the current finish time
            if (startTimes[i] >= currMax) {
                optimals[count] = i;
                // Make sure the current value has the least finish time out of all options
                for (int j = 0; j < startTimes.length; j++) {
                    if (finishTimes[j] < finishTimes[i] && startTimes[j] >= currMax) {
                        optimals[count] = j;
                    }
                }
                // Set the new current maximum finish time
                currMax = finishTimes[optimals[count]];
                count++;
            }
            i++;
        }
        return shrink(count, optimals);
    }

    // Helper method that can shrink down an array which will help remove extra values from optimals[]
    private int[] shrink (int size, int[] arr) {
        int[] copy = new int[size];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
