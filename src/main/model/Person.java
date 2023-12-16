package main.model;

import main.Gender;

import java.util.Comparator;

public class Person {
    private Long id;
    private String name;
    private int age;
    private Gender gender;

    public Person() {
    }

    public Person(Long id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
    public static Comparator<Person> sortbyName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Person> sortByGender = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().name().compareTo(o2.getGender().name());
        }
    };
}
