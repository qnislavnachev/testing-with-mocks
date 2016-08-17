package testwithmockendpointtask;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndpointFilterTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void shouldFilter() throws Exception {
        Endpoint endpoint = context.mock(Endpoint.class);
        EndpointFilter f = new EndpointFilter(endpoint);
        String url = "url";
        context.checking(new Expectations() {{
            oneOf(endpoint).matches(url);
            will(returnValue(true));
        }});
        assertTrue(f.shouldFilter(url));
    }

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