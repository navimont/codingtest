package ct;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class BinarySearch {
    @Test
    public void testBiny() {
        assertEquals(9, bfind(new int[]{1, 2, 3, 4, 4, 4, 5, 6, 6, 7, 8, 9, 10, 100, 1000}, 7));
    }

    @Test
    public void testBiny2() {
        assertEquals(-1, bfind(new int[]{1, 1, 2, 2, 2, 3, 4, 6, 7, 8, 9, 10}, 5));
    }


    @Test
    public void testBiny4() {
        assertEquals(0, bfind(new int[]{1, 1, 1, 1, 1}, 1));
    }

    @Test
    public void testBiny5() {
        assertEquals(4, bfind(new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 5));
    }

    @Test
    public void testBiny6() {
        assertEquals(-1, bfind(new int[]{}, 1));
    }

    @Test
    public void testBiny7() {
        assertEquals(0, bfind(new int[]{1}, 1));
    }

    @Test
    public void testBiny8() {
        assertEquals(-1, bfind(new int[]{2}, 1));
    }

    private int bfind(int[] ints, int i) {
        return -1;
    }


}
