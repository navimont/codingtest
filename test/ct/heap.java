package ct;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Heap {
    @Test
    public void testShort() {
        List<Integer> data = Arrays.asList(8, 4, 1, 2, 4, 9, 5, 3, 8, 1);
        List<Integer> sorted = siftupDownSort(data);
        assertSorted(sorted);
    }

    @Test
    public void testLongRandom() {
        List<Integer> data = new Random().ints(30).boxed().collect(Collectors.toList());
        List<Integer> sorted = siftupDownSort(data);
        assertSorted(sorted);
    }

    @Test
    public void testSorted() {
        List<Integer> data = Arrays.asList(4,5,6,7,8,9,9,9,10,11,15,60);
        List<Integer> sorted = siftupDownSort(data);
        assertSorted(sorted);
    }

    @Test
    public void testAllTheSame() {
        List<Integer> data = Arrays.asList(4,4,4,4,4,4,4);
        List<Integer> sorted = siftupDownSort(data);
        assertSorted(sorted);
    }

    @Test
    public void testDegenerated() {
        List<Integer> data = Arrays.asList(8);
        List<Integer> sorted = siftupDownSort(data);
        assertSorted(sorted);
    }

    private void assertSorted(List<Integer> sorted) {
        for (int i=1; i<sorted.size()-1; i++) {
            assertTrue(sorted.get(i) >= sorted.get(i-1));
        }
    }

    public List<Integer> siftupDownSort(List<Integer> data) {
        List<Integer> heap = new ArrayList();
        // fill first element
        heap.add(0, null);

        for (Integer i : data) {
            heap.add(i);
            siftup(heap);
        }
        verifyHeapContract(heap);
        List<Integer> sorted = new ArrayList();
        while (heap.size() > 1) {
            sorted.add(heap.get(1));
            siftdown(heap);
        }
        return sorted;
    }


    // element at position 1 was removed and following elements
    // need to shift to fill back the position
    private void siftdown(List<Integer> heap) {
        int i = 1;
        while (i*2+1 < heap.size()) {
            if (heap.get(i*2) < heap.get(i*2+1)) {
                heap.set(i, heap.get(i*2));
                i = i*2;
            } else {
                heap.set(i, heap.get(i*2+1));
                i = i*2+1;
            }
        }
        if (i < heap.size()) {
            heap.remove(i);
        }
    }

    private void verifyHeapContract(List<Integer> heap) {
        for (int i=1; i<heap.size(); i++) {
            assertNotNull(heap.get(i));
            if (i > 1) {
                assertTrue(heap.get(i) >= heap.get(i/2));
            }
        }
    }

    // move element in the last cell of the list to its proper place in the Heap
    // assume the rest of the Heap is already in order
    private void siftup(List<Integer> heap) {
        int i = heap.size()-1;
        while (i>1 && heap.get(i) < heap.get(i/2)) {
            int t = heap.get(i);
            heap.set(i, heap.get(i/2));
            heap.set(i/2, t);
            i = i/2;
        }
    }


    @Test
    public void heapsortInPlace() {
        int[] n = new int[] {4,6,2,8,35,88,3,9};
        heapsort(n);
        assertSteadyUp(n);
    }

    @Test
    public void heapsortInPlaceDegenerated0() {
        int[] n = new int[] {};
        heapsort(n);
        assertSteadyUp(n);
    }

    @Test
    public void heapsortInPlaceDegenerated1() {
        int[] n = new int[] {1};
        heapsort(n);
        assertSteadyUp(n);
    }

    @Test
    public void heapsortInPlaceSorted() {
        int[] n = new int[] {1,3,4,5,6,77,88,99,5664};
        heapsort(n);
        assertSteadyUp(n);
    }

    @Test
    public void heapsortInPlaceAllTheSame() {
        int[] n = new int[] {3,3,3,3,3,3,3,3,3,3,3};
        heapsort(n);
        assertSteadyUp(n);
    }

    @Test
    public void heapsortInPlaceRandomLarge() {
        int[] n = new Random().ints(30,0,100).toArray();
        heapsort(n);
        assertSteadyUp(n);
    }

    private void heapsort(int[] h) {
        for (int l=1; l < h.length; l++) {
            siftUp(h, l);
        }
        // build sorted array
        for (int i=h.length-1; i>=0; i--) {
            int m = h[0];
            repairAfterTakingRootElementAtIndex0(h, i);
            h[i] = m;
        }
    }

    // consider h[l] the element to be inserted into the Heap
    // and sifted up towards root. The Heap extends from before h(0,l-1) to after h(0,l)
    private void siftUp(int[] h, int l) {
        while (l > 0) {
            if (h[l] > h[(l-1)/2]) {
                int t = h[l];
                h[l] = h[(l-1) / 2];
                h[(l-1) / 2] = t;
            }
            l = (l-1) / 2;
        }
    }

    // Heap has size l
    private void repairAfterTakingRootElementAtIndex0(int[] h, int l) {
        if (l==2) {
            h[0]=h[1];
            return;
        }
        int i=0;
        while ((i+1)*2 < l) {
            if (h[(i+1)*2-1] > h[(i+1)*2]) {
                h[i] = h[(i+1)*2-1];
                i = (i+1)*2-1;
            } else {
                h[i] = h[(i+1)*2];
                i = (i+1)*2;
            }
        }
        while (i<l) {
            h[i] = h[i+1];
            i++;
        }
    }


    private void assertSteadyUp(int[] l) {
        for (int i=0; i<l.length; i++) {
            if (i>0 && l[i]<l[i-1]) {
                fail();
            }
        }
    }
}
