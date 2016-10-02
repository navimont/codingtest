package ct;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Eggdrop {
    @Test
    public void eggdropTest() {
        assertEquals(3, eggdrop(6));
        assertEquals(14, eggdrop(100));
    }

    public int eggdrop(int floor) {
        return -1;
    }

}
