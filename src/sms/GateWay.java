package sms;

public class GateWay {

    private final SmsSender sender;
    private final SmsValidator validator;

    public GateWay(SmsSender sender, SmsValidator validator) {
        this.sender = sender;
        this.validator = validator;
    }

    public boolean send(Sms sms) {
        return (validator.matches(sms));
    }

    public boolean matches(Sms sms) {
        return !(sms.receiver == null || sms.receiver.length() == 0)
                && (sms.text.length() > 0 && sms.text.length() <= 20);
    }
}
