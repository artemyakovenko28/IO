package serialization;

import java.io.Serializable;

public class PersonB implements Serializable {
    private String name;
    private int age;

    public PersonB(String name, int age) {
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
        return "PersonB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
