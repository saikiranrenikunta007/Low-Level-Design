package src.designpatterns.creational.abstractfactory.pizza.pizzafactory;

import src.designpatterns.creational.abstractfactory.pizza.pizza.CheesePizza;
import src.designpatterns.creational.abstractfactory.pizza.pizza.PepperoniPizza;
import src.designpatterns.creational.abstractfactory.pizza.pizza.Pizza;
import src.designpatterns.creational.abstractfactory.pizza.pizza.VeggiePizza;
import src.designpatterns.creational.abstractfactory.pizza.toppingfactory.BaseToppingFactory;
import src.designpatterns.creational.abstractfactory.pizza.toppingfactory.SicilianToppingFactory;

public class SicilianPizzaFactory extends BasePizzaFactory {
    @Override
    public  Pizza createPizza(String type){
        Pizza pizza;
       BaseToppingFactory toppingFactory= new SicilianToppingFactory();
        pizza = switch (type.toLowerCase()) {
            case "cheese" -> new CheesePizza(toppingFactory);
            case "pepperoni" -> new PepperoniPizza(toppingFactory);
            case "veggie" -> new VeggiePizza(toppingFactory);
            default -> throw new IllegalArgumentException("No such pizza.");
        };
        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}