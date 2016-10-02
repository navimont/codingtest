package ct;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomMOfN {

    @Test
    public void xxx() {
        int m = 7;
        int n = 40;

        int[] moutofn = randomNMSorted(n, m);

        verifyContract(n, m, moutofn);
    }

    @Test
    public void xxx1() {
        int n = 40;
        int m = 7;

        int[] moutofn = randomNMSorted_1(n, m);

        verifyContract(n, m, moutofn);
    }

    @Test
    public void xxx3() {
        int n = 40;
        int m = 7;

        int[] moutofn = randomNMSorted_Stream(n, m);

        verifyContract(n, m, moutofn);
    }

    private void verifyContract(int n, int m, int[] moutofn) {
        assertEquals(m, moutofn.length);
        System.out.print(moutofn[0]);
        for (int i=1; i<moutofn.length; i++) {
            System.out.print(", ");
            System.out.print(moutofn[i]);
            assertTrue(moutofn[i - 1] < moutofn[i]);
            assertTrue(moutofn[i]<n);
        }
    }

    private int[] randomNMSorted(int n, int m) {
        Random rand = new Random();
        int[] result = new int[m];

        int remaining = n;
        int select = m;
        for (int i=0; i<n; i++) {
            int randomN = rand.nextInt() % remaining;
            if (randomN >= 0 && randomN < select) {
                result[m-select] = i;
                select--;
            }
            remaining--;
        }

        return result;
    }


    private int[] randomNMSorted_1(int n, int m) {
        Set<Integer> result = new TreeSet<Integer>();

        Random rand = new Random();

        while(result.size() < m) {
            int candidate = rand.nextInt() % n;
            if (candidate >= 0 && !result.contains(candidate)) {
                result.add(candidate);
            }
        }

        return result.stream().mapToInt(x->x).toArray();
    }

    private int[] randomNMSorted_Stream(int n, int m) {
        List<Integer> result = IntStream.range(0, n).boxed().collect(Collectors.toList());
        Collections.shuffle(result);
        return result.subList(0, m).stream().sorted().mapToInt(x -> x).toArray();
    }
}
