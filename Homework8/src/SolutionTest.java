import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends ActivitySelection {
    @Test
    public void test1() {
        int[] start  =  {1, 3, 0, 5, 8, 5};
        int[] finish =  {2, 4, 6, 7, 9, 9};
        int[] res = findMaxActivities(start, finish), test = {0,1,3,4};
        assertArrayEquals(test, res);
    }
}
