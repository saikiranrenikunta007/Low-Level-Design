package src.designpatterns.creational.builder;

public class Student {

    private final String id;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", rollNo='" + rollNo + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    private String name;
    private int age;
    private String rollNo;

    private String branch;

    public static Builder builder(String id) { // here id is mandatory
        return new Builder(id);
    }

    Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.rollNo = builder.rollNo;
        this.branch = builder.branch;
    }


    public static class Builder {

        public Builder() {}

        public Builder(String id) {
            this.id = id;
        }

        private String id;
        private String name;
        private int age;

        private String rollNo;

        private String branch;

//        public Builder id(String id) {
//            this.id = id;
//            return this;
//        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder rollNo(String rollNo){
            this.rollNo = rollNo;
            return this;
        }
        public Builder branch(String branch){
            this.branch = branch;
            return this;
        }
        public Student build()
        {
            return new Student(this);
        }
    }

}
