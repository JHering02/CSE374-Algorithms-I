import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends Solution {
    @Test
    public void test() {
        int res = 2;
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        assertEquals(res, networkDelayTime(times, 4, 2));;
    }
}
