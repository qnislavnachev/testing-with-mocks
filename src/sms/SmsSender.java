package sms;

public class SmsSender {
    private final GateWay gateWay;

    public SmsSender(GateWay gateWay) {
        this.gateWay = gateWay;
    }

    public boolean sendSms(Sms sms) {
        if (gateWay.matches(sms)) {
            return true;
        }
        return false;
    }
}
