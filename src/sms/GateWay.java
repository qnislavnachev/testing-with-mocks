package sms;

public class GateWay {

    private final Sender sender;
    private final Validator validator;

    public GateWay(Sender sender, Validator validator) {
        this.sender = sender;
        this.validator = validator;
    }

    public boolean send(Sms sms) {
        if (!validator.matches(sms)) {
            return false;
        }
        return sender.send(sms);
    }
}