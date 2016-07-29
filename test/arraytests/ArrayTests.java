package arraytests;

import array.Array;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by clouway on 19.07.16.
 *
 * @author Denis Dimitrov(@denis.k.dimitrov@gmail.com)
 */
public class ArrayTests {

    @Test
    public void minElementTest() throws Exception {
        Array array = new Array(new int[]{1, 100});
        assertEquals(1, array.minElement());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void minElementEmptyArrayTest() throws Exception {
        Array array = new Array(new int[]{});
        assertEquals(1, array.minElement());
    }

    @Test
    public void sumArrayElementsTest() throws Exception {
        Array array = new Array(new int[]{5, 10});
        assertEquals(15, array.getSum());
    }

    @Test
    public void sumEmptyArrayTest() throws Exception {
        Array array = new Array(new int[]{});
        assertEquals(0, array.getSum());
    }
}