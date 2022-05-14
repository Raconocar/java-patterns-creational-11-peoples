package training.netology;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String actualLivingCity;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException(" Age not valid!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.actualLivingCity = address;
        return this;
    }

    public Person build() {
        if (this.name == null) throw new IllegalStateException("Name is empty!");
        if (this.surname == null) throw new IllegalStateException("Surname is empty!");
        Person GeneratedPerson = new Person(this.name, this.surname, this.age);
        GeneratedPerson.setAddress(this.actualLivingCity);
        return GeneratedPerson;
    }
}

