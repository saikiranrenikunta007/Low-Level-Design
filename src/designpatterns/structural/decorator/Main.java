package src.designpatterns.structural.decorator;

interface Coffee {

    double cost();
    String description();
}
class SimpleCoffee implements Coffee{

    @Override
    public double cost() {
        return 0.5;
    }

    @Override
    public String description() {
        return "Coffee";
    }
}
class DecoratedCoffee implements Coffee{

    private Coffee decoratedCoffee;

    DecoratedCoffee(Coffee decoratedCoffee)
    {
        this.decoratedCoffee = decoratedCoffee;
    }
    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}
class MilkDecorator extends DecoratedCoffee{
    MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
    @Override
    public String description() {
        return super.description() + ",Milk";
    }


}
class SugarDecorator extends DecoratedCoffee{
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.7;
    }
    @Override
    public String description() {
        return super.description() + ",Sugar";
    }


}
public class Main {

    public static void main(String[] args) {
        SimpleCoffee  coffee = new SimpleCoffee();
        System.out.println("Cost : $"+coffee.cost()+" Description : "+coffee.description());
        MilkDecorator milkDecorator = new MilkDecorator(coffee);
        System.out.println("Cost : $"+milkDecorator.cost()+" Description : "+milkDecorator.description());
        SugarDecorator sugarDecorator = new SugarDecorator(milkDecorator);
        System.out.println("Cost : $"+sugarDecorator.cost()+" Description : "+sugarDecorator.description());
    }
}
