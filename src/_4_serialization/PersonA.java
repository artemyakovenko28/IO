package _4_serialization;

public class PersonA {
    private String name;
    private int age;

    public PersonA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
