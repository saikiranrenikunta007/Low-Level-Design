package src.designpatterns.creational.abstractfactory.pizza.toppingfactory;

import src.designpatterns.creational.abstractfactory.pizza.cheese.Cheese;
import src.designpatterns.creational.abstractfactory.pizza.cheese.MozzarellaCheese;
import src.designpatterns.creational.abstractfactory.pizza.sauce.Sauce;
import src.designpatterns.creational.abstractfactory.pizza.sauce.TomatoSauce;

public class SicilianToppingFactory extends BaseToppingFactory{
    @Override
    public Cheese createCheese(){return new MozzarellaCheese();}
    @Override
    public Sauce createSauce(){return new TomatoSauce();}
}