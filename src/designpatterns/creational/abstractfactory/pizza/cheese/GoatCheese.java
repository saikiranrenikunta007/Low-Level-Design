package src.designpatterns.creational.abstractfactory.pizza.cheese;

public class GoatCheese implements Cheese{
    public GoatCheese() {
        prepareCheese();
    }
    @Override
    public void prepareCheese() {
        System.out.println("preparing goat cheese");
    }
}
