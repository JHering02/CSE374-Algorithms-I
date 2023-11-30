import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends Solution {
    @Test
    public void test() {
        int[][] res = {{5, 6, 11, 12, 13}, {13, 12, 11, 6, 5}};
        int[] in = {12, 11, 13, 6, 5};
        assertArrayEquals(res, sort(in));;
    }
}
