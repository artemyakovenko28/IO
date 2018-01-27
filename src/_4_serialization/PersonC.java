package _4_serialization;

import java.io.Serializable;

public class PersonC implements Serializable {
    private transient String name;
    private int age;

    public PersonC(String name, int age) {
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
        return "PersonC{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
