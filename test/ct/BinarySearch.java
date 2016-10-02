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
        int[] allOnes = new int[]{1, 1, 1, 1, 1};
        int found = bfind(allOnes, 1);
        assertEquals(1, allOnes[found]);
    }

    @Test
    public void testBiny5() {
        int[] manyFives = new int[]{1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int found = bfind(manyFives, 5);
        assertEquals(5, manyFives[found]);
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

    private int bfind(int[] ints, int f) {
        int l = 0;
        int u = ints.length;
        int m;
        while(l<u) {
            m = (u-l)/2+l;
            if (ints[m]==f) {
                return m;
            }
            if (ints[m]<f) {
                l = m+1;
            } else {
                u = m-1;
            }
        }

        return -1;

    }


}
