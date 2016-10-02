package ct;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by sw on 21.09.16.
 */
public class CycleTest {
    private final int SIZE = 11;

    @Test
    public void test() {
        List<Integer> raw = IntStream.range(0, SIZE).boxed().collect(Collectors.toList());
        raw.set(1, raw.get(0));
        Collections.shuffle(raw);
        System.out.println(raw);
        int[] n = raw.stream().mapToInt(x -> x).toArray();

        //        "You are given an array of integers of length n, where each element ranges
        //        from 0 to n - 2, inclusive.  Prove that at least one  duplicate element must
        //        exist, and give an O(n)-time, O(1)-space algorithm for finding some
        //        duplicated element.  You must not modify the array elements during this
        //        process.

        int indexOfDuplicate = findDuplicate(n);

        System.out.println(indexOfDuplicate);
        assertEquals(0, n[indexOfDuplicate]);
    }

    @Test
    public void test0() {
        assertEquals(-1, findDuplicate(new int[]{0}));
    }

    @Test
    public void test00() {
        assertEquals(0, findDuplicate(new int[]{1,1}));
    }

    @Test
    public void test001() {
        assertEquals(2, findDuplicate(new int[]{3,2,1,1}));
    }

    @Test
    public void testEmpty() {
        assertEquals(-1, findDuplicate(new int[]{}));
    }

    private int findDuplicate(int[] n) {
        if (n.length == 1) {
            return -1;
        }
        int h = 0;
        int t = 0;
        for (int i=0; i<n.length; i++) {
            h = n[n[h]];
            t = n[t];
            if (h == t) {
                return h;
            }
        }
        return -1;
    }
}
