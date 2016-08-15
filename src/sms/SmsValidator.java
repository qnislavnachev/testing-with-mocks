package sms;

public class SmsValidator implements GateWay {

    @Override
    public boolean matches(Sms sms) {
        if (sms.receiver == null || sms.receiver.length() == 0) {
            return false;
        }

        if (sms.text.length() > 0 && sms.text.length() <= 20) {
            return true;
        }
        return false;
    }
}
