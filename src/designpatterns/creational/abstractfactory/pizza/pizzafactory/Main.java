package src.designpatterns.creational.abstractfactory.pizza.pizzafactory;


public class Main {

    public static void main(String[] args) {
        BasePizzaFactory pizzaFactory = new GourmetPizzaFactory();
        pizzaFactory.createPizza("cheese");
        pizzaFactory.createPizza("pepperoni");
    }

}
