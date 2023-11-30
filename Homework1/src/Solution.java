import java.util.*;

/**
 * James Hering
 * Algorithms I
 * 9 September 2023
 * 
 * Just a simple insertion sort method which can also return a copy of the specified step.
 */
public class Solution {
	public static int[] insertionSort(int[] list,int N) {
		int[] res = {};
		int stepCounter = 0;
		if (N == stepCounter) {
			res = Arrays.copyOf(list, list.length);
		}
		for (int i = 1; i < list.length; i++) {
			int curr = list[i];
			int j = i - 1;
			while (j >= 0 && list[j] > curr) {
				list[j + 1] = list[j];
				list[j] = curr;
				j--;
				stepCounter++;
				if (N == stepCounter) {
					res = Arrays.copyOf(list, list.length);
				}
			}
		}
		return res;
	}
}