package sms;

public class Validator implements SmsValidator {

    @Override
    public boolean matches(Sms sms) {
        return !(sms.receiver == null || sms.receiver.length() == 0)
                && (sms.text.length() > 0 && sms.text.length() <= 20);
    }
}
