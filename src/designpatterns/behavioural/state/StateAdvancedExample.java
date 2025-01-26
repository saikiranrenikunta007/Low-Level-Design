package src.designpatterns.behavioural.state;

// State Interface
interface OrderState {
    void processOrder();
}

// Concrete States
class NewOrder implements OrderState {
    public void processOrder() { System.out.println("Order is placed. Waiting for processing."); }
}

class ProcessingOrder implements OrderState {
    public void processOrder() { System.out.println("Order is being prepared for shipment."); }
}

class ShippedOrder implements OrderState {
    public void processOrder() { System.out.println("Order has been shipped."); }
}

// Context
class Order {
    private OrderState state;

    void setState(OrderState state) { this.state = state; }
    void nextStep() { state.processOrder(); }
}

// Client
public class StateAdvancedExample {
    public static void main(String[] args) {
        Order order = new Order();

        order.setState(new NewOrder());
        order.nextStep();

        order.setState(new ProcessingOrder());
        order.nextStep();

        order.setState(new ShippedOrder());
        order.nextStep();
    }
}

