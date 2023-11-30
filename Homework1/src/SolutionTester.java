import java.util.Arrays;
public class SolutionTester extends Solution {
    public static void main(String[] args) {
        int[] test = {12, 11, 13, 5, 6};
        System.out.println(Arrays.toString(Solution.insertionSort(test, 1)));
    }
}