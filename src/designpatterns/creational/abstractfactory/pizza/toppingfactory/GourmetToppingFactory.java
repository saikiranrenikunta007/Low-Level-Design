package src.designpatterns.creational.abstractfactory.pizza.toppingfactory;

import src.designpatterns.creational.abstractfactory.pizza.cheese.Cheese;
import src.designpatterns.creational.abstractfactory.pizza.cheese.GoatCheese;
import src.designpatterns.creational.abstractfactory.pizza.sauce.CaliforniaOilSauce;
import src.designpatterns.creational.abstractfactory.pizza.sauce.Sauce;

public class GourmetToppingFactory extends BaseToppingFactory{
    @Override
    public Cheese createCheese(){return new GoatCheese();}
    @Override
    public Sauce createSauce(){return new CaliforniaOilSauce();}
}
 