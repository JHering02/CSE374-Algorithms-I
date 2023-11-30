import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 1 October 2023
 * 
 * A Heap sort method that outputs 2 arrays in ascending + descending order.
 */
public class Solution {
	
	public int[][] sort(int[] list) {
		// Return empty for empty lists
		if (list.length == 0) {
			return new int[0][0];
		}
		// Return the single value for lists of length 1
		if (list.length <= 1) {
			int arr[][] = { { list[0] }, { list[0] } };
			return arr;
		}
		// Call the heapSort helper method
		heapSort(list);

		// The complete sorted array will be copied in descending order
		int[] resDESC = new int[list.length];
		for (int i = list.length - 1, j = 0; i >= 0; i--, j++) {
			resDESC[j] = list[i];
		}
		// Return the result
		int[][] res = { list, resDESC };
		return res;
	}

	private void buildMax(int[] list, int size) {
		// Build the max heap
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(list, i, size);
		}
	}

	private void heapSort(int[] list) {
		int size = list.length;
		buildMax(list, size);
		// Extract each element from the heap
		for (int i = size - 1; i >= 0; i--) {
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			// Call max heap for the reduced heap
			heapify(list, 0, i);
		}

	}

	private void heapify(int[] list, int i, int j) {
		int left = 2 * i + 1, right = 2 * i + 2;
		int max = i;
		// Check left node first
		if (left < j && list[left] > list[max])
			max = left;

		// Once the left node is checked, check right
		if (right < j && list[right] > list[max])
			max = right;
		
		// If the largest isn't the root
		if (max != i) {
			int temp = list[i];
			list[i] = list[max];
			list[max] = temp;
			// Recursively call
			heapify(list, max, j);
		}
	}
}
