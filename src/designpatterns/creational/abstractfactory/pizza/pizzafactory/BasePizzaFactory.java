package src.designpatterns.creational.abstractfactory.pizza.pizzafactory;

import src.designpatterns.creational.abstractfactory.pizza.pizza.Pizza;

public abstract class BasePizzaFactory {
    
    public abstract Pizza createPizza(String type);

}