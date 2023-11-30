import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends HouseRob {
    @Test
    public void test1() {
        int res = 68;
        int[] houses = {5,6,8,2,3,6,3,7,3,8,11,2,4,7,2,13,6,9,9,2};
        assertEquals(res, rob(houses));;
    }
}
