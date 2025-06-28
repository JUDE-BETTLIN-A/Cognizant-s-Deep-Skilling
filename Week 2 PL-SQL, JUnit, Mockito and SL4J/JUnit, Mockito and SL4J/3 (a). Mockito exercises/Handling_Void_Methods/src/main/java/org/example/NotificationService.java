package org.example;


public class NotificationService {

    private Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void process() {
        // This is the void method we're testing indirectly
        notifier.send("Hello User");
    }
}
