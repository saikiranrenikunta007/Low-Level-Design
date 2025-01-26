package src.designpatterns.structural.adapter;

// Existing old payment system
class OldPaymentSystem {
    void makePayment(String account, double amount) {
        System.out.println("Processing old payment of $" + amount + " for " + account);
    }
}

// Target Interface
interface NewPaymentProcessor {
    void processNewPayment(String account, double amount);
}

// Adapter
class PaymentAdapter implements NewPaymentProcessor {
    private OldPaymentSystem oldPaymentSystem = new OldPaymentSystem();

    public void processNewPayment(String account, double amount) {
        oldPaymentSystem.makePayment(account, amount);
        System.out.println("New system adapted to old payment system.");
    }
}

// Client
public class AdapterAdvancedExample {
    public static void main(String[] args) {
        NewPaymentProcessor processor = new PaymentAdapter();
        processor.processNewPayment("ACC7890", 250);
    }
}

