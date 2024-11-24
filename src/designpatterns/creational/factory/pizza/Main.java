package src.designpatterns.creational.factory.pizza;

public class Main {
    public static void main(String[] args) {
        BasePizzaFactory factory = new PizzaFactory();
        Pizza cheesePizza = factory.createPizza("cheese");
        Pizza veggiePizza = factory.createPizza("veggie");
    }
}
