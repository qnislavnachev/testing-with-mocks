package sms;

public class Sms {
    public final String receiver;
    private final String title;
    public final String text;

    public Sms(String receiver, String title, String text) {
        this.receiver = receiver;
        this.title = title;
        this.text = text;
    }
}
