
import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends Solution {
    @Test
    public void test() {
        int[][] res = {{1,2,3,4,5}, {5,4,3,2,1}};
        int[] in = {1,5,3,4,2};
        assertArrayEquals(res, mergeSort(in));;
    }
}
