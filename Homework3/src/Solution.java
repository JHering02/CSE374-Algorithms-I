import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 19 September 2023
 * 
 * A Quick sort method that outputs 2 arrays in ascending + descending order.
 */
public class Solution {

	/*
	 * This Base method will process and return the result using both the sort/partition helper methods.
	 */
	public int[][] sort(int[] list) {
		// Return an empty array if there's no elements 
		if (list.length < 1)
			return new int[][] {};
		// Return a single element in each if there's one element
		if (list.length == 1) 
			return new int[][] {{list[0]}, {list[0]}};
		// Sort the list input
		quickSort(list, 0, list.length);
		// The complete sorted array will be copied in descending order
		int[] resDESC = new int[list.length];
		for (int i = list.length - 1, j = 0; i >= 0; i--, j++) {
			resDESC[j] = list[i];
		}
		// Return the result
		int[][] res = {list, resDESC};
		return res;
	}

	/*
	 * Quicksort is a helper method that implements recursion divide/conquer to sort the list input.
	 */
	private void quickSort(int[] list, int p, int len) {
		// Recursively partition the list for n/2 subarrays
		if (p < len) {
			int q = partition(list, p, len);
			quickSort(list, p, q);
			quickSort(list, q + 1, len);
		}
	}

	/*
	 * Partition, once called, will loop through a given length of the list, and return a new midpoint to start sorting.
	 */
	private int partition(int[] list, int p, int len) {
		// Determine the pivot point and make a dummy variable that starts at the pivot
		int pivot = list[p];
		int i = p;
		// Sort the array so that 0 <= p <= len
		for (int j = p + 1; j < len; j++) {
			if (list[j] <= pivot) {
				// Swap the values if the condition is met
				i++;
				int temp = list[i];
				list[i] = list[j];
				list[j] = temp;
			}
		}
		// Return the new pivot point
		int temp = list[i];
		list[i] = list[p];
		list[p] = temp;
		return i;
	}
}

