package training.netology;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1; //изначально предполагаем что возраст неизвестен
    protected String actualLivingCity;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age != -1;
    }

    public boolean hasAddress() {
        return this.actualLivingCity != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;// всегда возвращаем -1 если возраст неизвестен
    }

    public String getAddress() {
        return (this.hasAddress()) ? this.actualLivingCity : "Адрес не заполнен";
    }

    public void setAddress(String address) {
        this.actualLivingCity = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder children = new PersonBuilder();
        children.setAddress(this.getAddress());
        children.setSurname(this.getSurname());
        return children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", actualLivingCity='" + actualLivingCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        if (!surname.equals(person.surname)) return false;
        return actualLivingCity != null ? actualLivingCity.equals(person.actualLivingCity) : person.actualLivingCity == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + (actualLivingCity != null ? actualLivingCity.hashCode() : 0);
        return result;
    }
}