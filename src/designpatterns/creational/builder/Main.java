package src.designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        Student s = Student
                .builder("123890")
                .age(10)
                .branch("abc")
                .name("abc")
                .rollNo("ahf")
                .build();
        System.out.println(s);
    }
}
