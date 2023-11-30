import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends Solution {
    @Test
    public void test1() {
        int[] prices  =  {1, 3, 2, 8, 4, 9};
        int fee = 2;
        assertEquals(8, maxProfit(prices, fee));
    }

    @Test
    public void test2() {
        int[] prices  =  {1, 3, 7, 5, 10, 3};
        int fee = 3;
        assertEquals(6, maxProfit(prices, fee));
    }
}
