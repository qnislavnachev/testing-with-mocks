import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by clouway on 18.07.16.
 *
 * @author Denis Dimitrov(@denis.k.dimitrov@gmail.com)
 */
public class SumatorTests {
    @Test
    public void happyPath() throws Exception {
        Sumator sum = new Sumator("0").plus(new Sumator("0"));
        assertEquals("0", sum.stringValue());
    }

    @Test
    public void addPositiveToZero() throws Exception {
        Sumator sum = new Sumator("1").plus(new Sumator("0"));
        assertEquals("1", sum.stringValue());
    }

    @Test
    public void addZeroToPositive() throws Exception {
        Sumator sum = new Sumator("0").plus(new Sumator("2"));
        assertEquals("2", sum.stringValue());
    }

    @Test
    public void addNegativeToZero() throws Exception {
        Sumator sum = new Sumator("-1").plus(new Sumator("0"));
        assertEquals("-1", sum.stringValue());
    }

    @Test
    public void addZeroToNegative() throws Exception {
        Sumator sum = new Sumator("0").plus(new Sumator("-3"));
        assertEquals("-3", sum.stringValue());
    }

    @Test
    public void addPositiveToPositive() throws Exception {
        Sumator sum = new Sumator("2").plus(new Sumator("3"));
        assertEquals("5", sum.stringValue());
    }

    @Test
    public void addNegativeToPositive() throws Exception {
        Sumator sum = new Sumator("-2").plus(new Sumator("5"));
        assertEquals("3", sum.stringValue());
    }

    @Test
    public void addPositiveToNegative() throws Exception {
        Sumator sum = new Sumator("2").plus(new Sumator("-5"));
        assertEquals("-3", sum.stringValue());
    }

    @Test
    public void addNegativeToNegative() throws Exception {
        Sumator sum = new Sumator("-5").plus(new Sumator("-2"));
        assertEquals("-7", sum.stringValue());
    }

    @Test
    public void testWrongSymbol() throws Exception {
        boolean thrown = false;
        try {
            new Sumator("ASD").plus(new Sumator("123"));
        } catch (NumberFormatException z) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testNullArgument() throws Exception {
        boolean thrown = false;
        try {
            new Sumator(null).plus(new Sumator(null));
        } catch (IllegalArgumentException z) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
