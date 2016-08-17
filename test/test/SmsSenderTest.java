package test;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import sms.*;

import static org.junit.Assert.*;

public class SmsSenderTest {

    private Validator validator = new Validator();
    private Sender sender = new Sender(validator);

    @Test
    public void happyPath() throws Exception {
        Sms sms = new Sms("Iani", "Work", "You are late!");
        boolean done1 = sender.send(sms);
        assertTrue(done1);
    }

    @Test
    public void noReceiverFound() throws Exception {
        Sms sms1 = new Sms("", "Work", "You are late !");
        Sms sms2 = new Sms(null, "Work", "You are late !");
        boolean done1 = sender.send(sms1);
        boolean done2 = sender.send(sms2);
        assertFalse(done1);
        assertFalse(done2);
    }

    @Test
    public void smsTextOutOfBounds() throws Exception {
        String outOfBoundsText = "Out of bounds text! You cannot enter more then 20 characters!";
        Sms sms1 = new Sms("Iani", "", "");
        Sms sms2 = new Sms("Iani", "", outOfBoundsText);
        boolean done1 = sender.send(sms1);
        boolean done2 = sender.send(sms2);
        assertFalse(done1);
        assertFalse(done2);
    }

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPathWithMock() throws Exception {
        SmsSender smsSender = context.mock(SmsSender.class);
        SmsValidator smsValidator = context.mock(SmsValidator.class);
        GateWay gateway = new GateWay(smsSender, smsValidator);
        Sms sms = new Sms("Iani", "Work", "You are late!");

        context.checking(new Expectations() {{
            oneOf(smsValidator).matches(sms);
            will(returnValue(true));
        }});

        assertTrue(gateway.send(sms));
    }

    @Test
    public void noReceiverFoundWithMock() throws Exception {
        SmsSender smsSender = context.mock(SmsSender.class);
        SmsValidator smsValidator = context.mock(SmsValidator.class);
        GateWay gateway = new GateWay(smsSender, smsValidator);
        Sms sms1 = new Sms("", "Work", "You are late!");
        Sms sms2 = new Sms(null, "Work", "You are late!");

        context.checking(new Expectations() {{
            oneOf(smsValidator).matches(sms1);
            will(returnValue(false));

            oneOf(smsValidator).matches(sms2);
            will(returnValue(false));
        }});

        assertFalse(gateway.send(sms1));
        assertFalse(gateway.send(sms2));
    }

    @Test
    public void smsTextOutOfBoundsWithMock() throws Exception {
        SmsSender smsSender = context.mock(SmsSender.class);
        SmsValidator smsValidator = context.mock(SmsValidator.class);
        GateWay gateway = new GateWay(smsSender, smsValidator);
        String outOfBoundsText = "Out of bounds text! You cannot enter more then 20 characters!";
        Sms sms1 = new Sms("Iani", "", "");
        Sms sms2 = new Sms("Iani", "", outOfBoundsText);

        context.checking(new Expectations() {{
            oneOf(smsValidator).matches(sms1);
            will(returnValue(false));

            oneOf(smsValidator).matches(sms2);
            will(returnValue(false));
        }});

        assertFalse(gateway.send(sms1));
        assertFalse(gateway.send(sms2));
    }
}