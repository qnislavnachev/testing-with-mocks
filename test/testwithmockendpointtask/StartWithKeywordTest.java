package testwithmockendpointtask;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StartWithKeywordTest {

    @Test
    public void startWithKeyword() throws Exception {
        StartsWithKeyword matcher = new StartsWithKeyword("www");
        String url = "www.test.com";
        assertTrue(matcher.matches(url));
    }

    @Test
    public void startWithKeywordFail() throws Exception {
        StartsWithKeyword matcher = new StartsWithKeyword("ccc");
        String url = "www.test.com";
        assertFalse(matcher.matches(url));
    }
}
