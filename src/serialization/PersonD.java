package serialization;

import java.io.Serializable;

public class PersonD implements Serializable{
    private transient String name;
    private int age;
    private Address address;

    public PersonD(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonD{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
