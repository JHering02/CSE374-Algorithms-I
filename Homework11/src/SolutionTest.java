import org.junit.Test;
import static org.junit.Assert.*;;

public class SolutionTest extends Solution {
    @Test
    public void wordPatternTestTrue() {
        assertEquals(true, new Solution().wordPattern("abba", "dog cat cat dog"));
        assertEquals(true, new Solution().wordPattern("aaaa", "dog dog dog dog"));
    }

    @Test
    public void wordPatternTestFalse() {
        assertEquals(false, new Solution().wordPattern("abba", "dog cat cat fish"));
        assertEquals(false, new Solution().wordPattern("abba", "dog dog dog dog"));
        assertEquals(false, new Solution().wordPattern("aaaa", "dog cat cat dog"));
        assertEquals(false, new Solution().wordPattern("aaa", "aa aa aa aa"));
    }
}
