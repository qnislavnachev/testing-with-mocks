package test;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import sms.GateWay;
import sms.Sms;
import sms.SmsSender;
import sms.SmsValidator;

import static org.junit.Assert.*;

public class SmsSenderTest {

    private SmsValidator validator = new SmsValidator();
    private SmsSender sender = new SmsSender(validator);

    @Test
    public void happyPath() throws Exception {
        Sms sms = new Sms("Iani", "Work", "You are late!");
        boolean done1 = sender.sendSms(sms);
        assertTrue(done1);
    }

    @Test
    public void noReceiverFound() throws Exception {
        Sms sms1 = new Sms("", "Work", "You are late !");
        Sms sms2 = new Sms(null, "Work", "You are late !");
        boolean done1 = sender.sendSms(sms1);
        boolean done2 = sender.sendSms(sms2);
        assertFalse(done1);
        assertFalse(done2);
    }

    @Test
    public void smsTextOutOfBounds() throws Exception {
        String outOfBoundsText = "Out of bounds text! You cannot enter more then 20 characters!";
        Sms sms1 = new Sms("Iani", "", "");
        Sms sms2 = new Sms("Iani", "", outOfBoundsText);
        boolean done1 = sender.sendSms(sms1);
        boolean done2 = sender.sendSms(sms2);
        assertFalse(done1);
        assertFalse(done2);
    }

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void happyPathWithMock() throws Exception {
        GateWay gateWay = context.mock(GateWay.class);
        SmsSender sender = new SmsSender(gateWay);
        Sms sms = new Sms("Iani", "Work", "You are late!");

        context.checking(new Expectations() {{
            oneOf(gateWay).matches(sms);
            will(returnValue(true));
        }});

        assertTrue(sender.sendSms(sms));
    }

    @Test
    public void noReceiverFoundWithMock() throws Exception {
        GateWay gateWay = context.mock(GateWay.class);
        SmsSender sender = new SmsSender(gateWay);
        Sms sms1 = new Sms("", "Work", "You are late!");
        Sms sms2 = new Sms(null, "Work", "You are late!");

        context.checking(new Expectations() {{
            oneOf(gateWay).matches(sms1);
            will(returnValue(false));

            oneOf(gateWay).matches(sms2);
            will(returnValue(false));
        }});

        assertFalse(sender.sendSms(sms1));
        assertFalse(sender.sendSms(sms2));
    }

    @Test
    public void smsTextOutOfBoundsWithMock() throws Exception {
        GateWay gateWay = context.mock(GateWay.class);
        SmsSender sender = new SmsSender(gateWay);
        String outOfBoundsText = "Out of bounds text! You cannot enter more then 20 characters!";
        Sms sms1 = new Sms("Iani", "", "");
        Sms sms2 = new Sms("Iani", "", outOfBoundsText);

        context.checking(new Expectations() {{
            oneOf(gateWay).matches(sms1);
            will(returnValue(false));

            oneOf(gateWay).matches(sms2);
            will(returnValue(false));
        }});

        assertFalse(sender.sendSms(sms1));
        assertFalse(sender.sendSms(sms2));
    }

}