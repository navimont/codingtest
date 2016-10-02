package ct;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;


public class Sort {
    public int SIZE = 8;

    @Test
    public void insertionRandom() {
        int[] numbers = new Random().ints(SIZE).toArray();

        insertsort(numbers);
        assertTrue(assertSteadyUp(numbers));
    }

    @Test
    public void insertionSorted() {
        int[] numbers = IntStream.range(0, SIZE).toArray();

        insertsort(numbers);
        assertTrue(assertSteadyUp(numbers));
    }

    @Test
    public void quickRandom() {
        int[] numbers = new Random().ints(SIZE, 0, 800).toArray();

        quicksort(numbers);
        assertTrue(assertSteadyUp(numbers));
    }

    @Test
    public void quickSorted() {
        int[] numbers = IntStream.range(0, SIZE).toArray();

        quicksort(numbers);
        assertTrue(assertSteadyUp(numbers));
    }

    private void quicksort(int[] n) {
        quicksortRecursion(n, 0, n.length-1);
    }

    private void quicksortRecursion(int[] n, int l, int u) {
        if (l >= u) {
            return;
        }
        int t = n[l];
        int i = l+1;
        int j = u;
        while(true) {
            // go up with i until n[i] > t
            while (i<=u && n[i] < t) {i++;}
            while (n[j] > t) {j--;}
            if (i > j) {break;}
            int temp = n[i]; n[i]=n[j]; n[j]=temp;
        }
        // swap l, j
        int temp = n[l]; n[l]=n[j]; n[j]=temp;
        quicksortRecursion(n, l, j-1);
        quicksortRecursion(n, j+1, u);
    }

    private void insertsort(int[] l) {
       for (int i=0; i<l.length; i++) {
           int j = i;
           while (j > 0 && l[j-1] > l[j]) {
               int t = l[j]; l[j]=l[j-1]; l[j-1]=t;
               j--;
           }
       }
    }

    private boolean assertSteadyUp(int[] l) {
        for (int i=0; i<l.length; i++) {
            if (i>0 && l[i]<l[i-1]) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void duplicate() {
        List<Integer> ints = IntStream.range(0, SIZE).boxed().collect(Collectors.toList());
        // duplicate the first entry
        ints.set(1, ints.get(0));
        Collections.shuffle(ints);
        int[] arrayWithDuplicate = ints.stream().mapToInt(x->x).toArray();



    }
}
