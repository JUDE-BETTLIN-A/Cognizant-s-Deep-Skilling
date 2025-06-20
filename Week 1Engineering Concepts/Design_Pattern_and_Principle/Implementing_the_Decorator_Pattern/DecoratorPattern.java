//Component Interface
interface Notifier {
    void send(String message);
}

//Concrete Component
class EmailNotifier implements Notifier {
 
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

//Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);  
    }
}

//Concrete Decorators
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);  
        sendSMS(message);    
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);   
        sendSlack(message);   
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}

//Test Class
public class DecoratorPattern {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);

        Notifier allChannels = new SlackNotifierDecorator(emailAndSMS);

        System.out.println("== Sending Notification ==");
        allChannels.send("Your order has been shipped!");
    }
}
