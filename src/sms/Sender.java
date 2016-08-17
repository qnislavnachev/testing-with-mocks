package sms;

public class Sender implements SmsSender {

    private Validator validator;

    public Sender(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean send(Sms sms) {
        return (validator.matches(sms));
    }
}
