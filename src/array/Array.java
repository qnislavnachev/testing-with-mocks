package array;

import java.util.Arrays;

/**
 * Created by clouway on 19.07.16.
 *
 * @author Denis Dimitrov(@denis.k.dimitrov@gmail.com)
 */
public class Array {
    public final int[] value;

    public Array(int[] value) {
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }

    /**
     * Checks for the minimum element
     *
     * @return Returns the min element.
     */
    public int minElement() {
        int min = value[0];

        for (int i = 0; i < value.length; i++) {
            if (min > value[i]) {
                min = value[i];
            }
        }
        return min;
    }

    /**
     * Sums the value of the elements
     *
     * @return Returns the sum of the elements in the array.
     */
    public int getSum() {
        int sum = 0;
        for (int k = 0; k < value.length; k++) {
            sum += value[k];
        }
        return sum;
    }
}
