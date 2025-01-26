package src.designpatterns.structural.facade;

// Subsystems
class PaymentAuthorization {
    boolean authorize(String account, double amount) {
        System.out.println("Authorizing payment for " + account);
        return amount <= 1000; // Simulated rule
    }
}

class FraudCheck {
    boolean isFraudulent(String account) {
        System.out.println("Checking fraud for " + account);
        return false; // Simulated check
    }
}

class TransactionLogger {
    void logTransaction(String account, double amount) {
        System.out.println("Logging transaction of $" + amount + " for " + account);
    }
}

// Facade
class PaymentFacade {
    private PaymentAuthorization auth = new PaymentAuthorization();
    private FraudCheck fraudCheck = new FraudCheck();
    private TransactionLogger logger = new TransactionLogger();

    boolean processPayment(String account, double amount) {
        if (!fraudCheck.isFraudulent(account) && auth.authorize(account, amount)) {
            logger.logTransaction(account, amount);
            System.out.println("Payment processed successfully!");
            return true;
        }
        System.out.println("Payment failed!");
        return false;
    }
}

// Client
public class PaymentFacadeExample {
    public static void main(String[] args) {
        PaymentFacade facade = new PaymentFacade();
        facade.processPayment("ACC12345", 500);
    }
}

