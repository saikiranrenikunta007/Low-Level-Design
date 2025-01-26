package src.designpatterns.behavioural.visitor;

// Element Interface
interface InsurancePlan {
    void accept(InsuranceVisitor visitor);
}

// Concrete Elements
class LifeInsurance implements InsurancePlan {
    public void accept(InsuranceVisitor visitor) { visitor.calculatePremium(this); }
}

class HealthInsurance implements InsurancePlan {
    public void accept(InsuranceVisitor visitor) { visitor.calculatePremium(this); }
}

// Visitor Interface
interface InsuranceVisitor {
    void calculatePremium(LifeInsurance life);
    void calculatePremium(HealthInsurance health);
}

// Concrete Visitor
class PremiumCalculator implements InsuranceVisitor {
    public void calculatePremium(LifeInsurance life) {
        System.out.println("Calculating premium for Life Insurance (5% of sum insured).");
    }

    public void calculatePremium(HealthInsurance health) {
        System.out.println("Calculating premium for Health Insurance (3% of sum insured).");
    }
}

// Client
public class VisitorAdvancedExample {
    public static void main(String[] args) {
        InsurancePlan life = new LifeInsurance();
        InsurancePlan health = new HealthInsurance();
        InsuranceVisitor calculator = new PremiumCalculator();

        life.accept(calculator);
        health.accept(calculator);
    }
}

