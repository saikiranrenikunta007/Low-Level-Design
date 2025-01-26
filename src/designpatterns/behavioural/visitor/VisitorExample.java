package src.designpatterns.behavioural.visitor;

// Element interface
interface Product {
    void accept(TaxVisitor visitor);
}

// Concrete Elements
class Food implements Product {
    public void accept(TaxVisitor visitor) { visitor.visit(this); }
}

class Electronics implements Product {
    public void accept(TaxVisitor visitor) { visitor.visit(this); }
}

// Visitor interface
interface TaxVisitor {
    void visit(Food food);
    void visit(Electronics electronics);
}

// Concrete Visitor
class TaxCalculator implements TaxVisitor {
    public void visit(Food food) { System.out.println("Applying 5% tax on Food."); }
    public void visit(Electronics electronics) { System.out.println("Applying 18% tax on Electronics."); }
}

// Client
public class VisitorExample {
    public static void main(String[] args) {
        Product food = new Food();
        Product electronics = new Electronics();
        TaxVisitor taxCalculator = new TaxCalculator();

        food.accept(taxCalculator);
        electronics.accept(taxCalculator);
    }
}
