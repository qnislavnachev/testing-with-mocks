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
    public void happyPath() throws Exception {
        Array array = new Array(new int[]{0, 0, 0});
        assertArrayEquals(new int[]{0, 0, 0}, array.getValue());
    }

    @Test
    public void minElementExistsTest() throws Exception {
        Array array = new Array(new int[]{0, 0, 0});
        assertEquals(0, array.minElement());
    }

    @Test
    public void minElementCanBeZeroTest() throws Exception {
        Array array = new Array(new int[]{0, 1, 2});
        assertEquals(0, array.minElement());
    }

    @Test
    public void minElementCanBePositiveTest() throws Exception {
        Array array = new Array(new int[]{1, 2, 3});
        assertEquals(1, array.minElement());
    }

    @Test
    public void minElementCanBeNegativeTest() throws Exception {
        Array array = new Array(new int[]{-3, -2, -1});
        assertEquals(-3, array.minElement());
    }

    @Test
    public void minElementCanBePositiveFractionTest() throws Exception {
        Array array = new Array(new int[]{2, 5 / 5, 10});
        assertEquals(1, array.minElement());
    }

    @Test
    public void minElementCanBeNegativeFractionTest() throws Exception {
        Array array = new Array(new int[]{5, -10 / 5, 10});
        assertEquals(-2, array.minElement());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void arrayIsEmptyTest() throws Exception {
        Array array = new Array(new int[]{});
        assertEquals(1, array.minElement());
    }

    @Test
    public void sumEmptyArrayTest() throws Exception {
        Array array = new Array(new int[]{});
        assertEquals(0, array.getSum());
    }

    @Test
    public void sumZeroToZeroTest() throws Exception {
        Array array = new Array(new int[]{0, 0});
        assertEquals(0, array.getSum());
    }

    @Test
    public void sumZeroToPositiveTest() throws Exception {
        Array array = new Array(new int[]{0, 1});
        assertEquals(1, array.getSum());
    }

    @Test
    public void sumPositiveToZeroTest() throws Exception {
        Array array = new Array(new int[]{4, 0});
        assertEquals(4, array.getSum());
    }

    @Test
    public void sumZeroToNegativeTest() throws Exception {
        Array array = new Array(new int[]{0, -2});
        assertEquals(-2, array.getSum());
    }

    @Test
    public void sumNegativeToZeroTest() throws Exception {
        Array array = new Array(new int[]{-3, 0});
        assertEquals(-3, array.getSum());
    }

    @Test
    public void sumPositiveToPositiveTest() throws Exception {
        Array array = new Array(new int[]{1, 1});
        assertEquals(2, array.getSum());
    }

    @Test
    public void sumNegativeToPositiveTest() throws Exception {
        Array array = new Array(new int[]{-5, 2});
        assertEquals(-3, array.getSum());
    }

    @Test
    public void sumZeroToPositiveFractionTest() throws Exception {
        Array array = new Array(new int[]{0, 5 / 10});
        assertEquals(1 / 2, array.getSum());
    }

    @Test
    public void sumPositiveFractionToZeroTest() throws Exception {
        Array array = new Array(new int[]{20 / 10, 0});
        assertEquals(2, array.getSum());
    }

    @Test
    public void sumZeroToNegativeFractionTest() throws Exception {
        Array array = new Array(new int[]{0, -6 / 2});
        assertEquals(-3, array.getSum());
    }

    @Test
    public void sumPositiveFractionToPositiveFractionTest() throws Exception {
        Array array = new Array(new int[]{2 / 4, 10 / 5});
        assertEquals(2, array.getSum());
    }

    @Test
    public void sumNegativeFractionToNegativeFractionTest() throws Exception {
        Array array = new Array(new int[]{-25 / 10, -50 / 40});
        assertEquals(-3, array.getSum());
    }
}