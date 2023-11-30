
import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 17 September 2023
 * 
 * A Merge sort method that outputs 2 arrays in ascending + descending order.
 */
public class Solution {

	// This is the base method that is called to do the merge sort.
	// According to the solution, it takes in an array, merge sorts,
	// and then outputs a 2d Array containing the original array in both ascending +
	// descending order.
	public int[][] mergeSort(int[] list) {
		// Return empty for empty lists
		if (list.length == 0) {
			return new int[0][0];
		}
		// Return the single value for lists of length 1
		if (list.length <= 1) {
			int arr[][] = { { list[0] }, { list[0] } };
			return arr;
		}
		// Once we're ready to start sorting, begin by splitting
		list = split(list);

		// The complete sorted array will be copied in descending order
		int[] resDESC = new int[list.length];
		for (int i = list.length - 1, j = 0; i >= 0; i--, j++) {
			resDESC[j] = list[i];
		}
		// Return the result
		int[][] res = { list, resDESC };
		return res;
	}

	// Helper method that returns the minimum value of an array given a starting
	// point.
	private int arrMin(int[] list, int start) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < list.length; i++) {
			if (list[i] < min)
				min = list[i];
		}
		return min;
	}

	// Helper method to recursively split arrays as evenly as possible.
	private int[] split(int[] list) {
		// The left bound is set to the midpoint
		int m = list.length / 2;
		// The right bound will be larger if an odd number of values exist
		int r = (list.length % 2 == 0) ? m : m + 1;
		int[] left = new int[m];
		int[] right = new int[r];
		// Copy list values into split arrays
		for (int i = 0; i < left.length; i++)
			left[i] = list[i];
		for (int i = 0; i < right.length; i++)
			right[i] = list[m + i];
		// These conditions can't be combined in order for recursion to work properly
		if (left.length > 1)
			left = split(left);
		if (right.length > 1)
			right = split(right);
		// Once both bounds have been split down to 1, start merging
		return merge(left, right);
	}

	// Helper method to merge two split arrays back together sorted.
	private int[] merge(int[] left, int[] right) {
		// Make a new clear array to merge the values back into
		int[] res = new int[left.length + right.length];
		// We need counters to move the array forward once a value is placed into the
		// new one
		int count1 = 0, count2 = 0;
		for (int i = 0; i < res.length; i++) {
			// Add the smallest of both
			int min1 = arrMin(left, count1);
			int min2 = arrMin(right, count2);
			if (min1 > min2) {
				res[i] = min2;
				count2++;
			} else {
				res[i] = min1;
				count1++;
			}
		}
		return res;
	}
}