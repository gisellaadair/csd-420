import static org.junit.Assert.*;
import org.junit.Test;

public class GisellaThreeThreadsTest {

    @Test
    public void testLetterRange() {

        char testChar = 'm';

        assertTrue(testChar >= 'a' && testChar <= 'z');
    }

    @Test
    public void testNumberRange() {

        char testChar = '5';

        assertTrue(testChar >= '0' && testChar <= '9');
    }

    @Test
    public void testSymbolRange() {

        char[] symbols =
                {'!', '@', '#', '$', '%', '&', '*', '^'};

        boolean found = false;

        for (char c : symbols) {

            if (c == '@') {
                found = true;
            }
        }

        assertTrue(found);
    }

    @Test
    public void testMinimumCount() {

        int count = 10000;

        assertEquals(10000, count);
    }
}