package testmocks;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import sms.*;
import static org.junit.Assert.*;

public class GatewayTestMock {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Sender sender = context.mock(Sender.class);
    private Validator validator = context.mock(Validator.class);
    private GateWay gateway = new GateWay(sender, validator);

    @Test
    public void happyPath() throws Exception {
        Sms sms = new Sms("Iani", "Work", "You are late!");

        context.checking(new Expectations() {{
            oneOf(validator).matches(sms);
            will(returnValue(true));

            oneOf(sender).send(sms);
            will(returnValue(true));
        }});

        assertTrue(gateway.send(sms));
    }

    @Test
    public void sentWrongSms() throws Exception {
        Sms sms = new Sms("", "", "");

        context.checking(new Expectations() {{
            oneOf(validator).matches(sms);
            will(returnValue(false));
        }});

        assertFalse(gateway.send(sms));
    }
}