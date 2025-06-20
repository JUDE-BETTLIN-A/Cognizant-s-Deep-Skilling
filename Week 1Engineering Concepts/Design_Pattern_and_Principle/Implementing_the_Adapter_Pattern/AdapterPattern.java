//Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

//Adaptee Classes (3rd-party gateways with different methods)
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment through PayPal: $" + amount);
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment through Stripe: $" + amount);
    }
}

class Razorpay {
    public void doTransaction(double amount) {
        System.out.println("Processing payment through Razorpay: $" + amount);
    }
}

//Adapter Classes
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public void processPayment(double amount) {
        paypal.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private Razorpay razorpay;

    public RazorpayAdapter(Razorpay razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.doTransaction(amount);
    }
}

//Test Class
public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(1500.00);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(2500.00);

        PaymentProcessor razorpayProcessor = new RazorpayAdapter(new Razorpay());
        razorpayProcessor.processPayment(1000.00);
    }
}
