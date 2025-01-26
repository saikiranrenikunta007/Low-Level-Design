package src.designpatterns.structural.composite;

import java.util.*;

// Component
interface Employee {
    void showDetails();
}

// Leaf
class Developer implements Employee {
    private String name;
    private String position;

    Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void showDetails() {
        System.out.println(name + " (" + position + ")");
    }
}

// Composite
class Manager implements Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    Manager(String name) {
        this.name = name;
    }

    void addEmployee(Employee e) {
        subordinates.add(e);
    }

    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee e : subordinates) {
            e.showDetails();
        }
    }
}

// Client
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Manager ceo = new Manager("John Doe");
        Manager itManager = new Manager("Alice");

        itManager.addEmployee(new Developer("Bob", "Backend Developer"));
        itManager.addEmployee(new Developer("Charlie", "Frontend Developer"));

        ceo.addEmployee(itManager);
        ceo.showDetails();
    }
}

