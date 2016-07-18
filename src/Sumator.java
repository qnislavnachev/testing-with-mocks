/**
 * Created by clouway on 18.07.16.
 *
 * @author Denis Dimitrov(@denis.k.dimitrov@gmail.com)
 */
public class Sumator {
    public final String value;

    public Sumator(String value) {
        this.value = value;
    }

    public Sumator plus(Sumator that) {
        return new Sumator(String.valueOf(Integer.valueOf(this.value) + Integer.valueOf(that.value)));
    }

    public String stringValue() {
        return value;
    }
}
