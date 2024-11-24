package src.designpatterns.creational.abstractfactory.pizza.toppingfactory;

import src.designpatterns.creational.abstractfactory.pizza.cheese.Cheese;
import src.designpatterns.creational.abstractfactory.pizza.sauce.Sauce;

public abstract class BaseToppingFactory {
    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}