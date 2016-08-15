package sms;

public interface GateWay {
    boolean matches(Sms sms);
}
