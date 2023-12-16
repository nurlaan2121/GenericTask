package main.service.impl;

import main.Gender;
import main.model.Animal;
import main.model.Person;
import main.service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService {
    List<Person> people = new ArrayList<>();
    public static long id = 0;
    @Override
    public String add(List t) {
        Person person = new Person();
        while (true) {
            System.out.println("Write name: ");
            String name = new Scanner(System.in).nextLine();
            if (name.length() > 2) {
                person.setName(name);
                break;
            }
        }
        while (true) {
            try {
                System.out.println("Write age : ");
                int name = new Scanner(System.in).nextInt();
                if (name > 0 && name < 80) {
                    person.setAge(name);
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("San jazz!");
                new Scanner(System.in).reset();
            }
        }
        person.setId(++PersonServiceImpl.id);
        while (true) {
            System.out.println("Write Gender: (Male || Female)");
            String name = new Scanner(System.in).nextLine();
            if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                person.setGender(Gender.FEMALE);
                break;
            } else if (name.equalsIgnoreCase(Gender.MALE.name())) {
                person.setGender(Gender.MALE);
                break;
            }
        }
        people.add(person);
        t.add(people);
        return "Success!";
    }

    @Override
    public Object getById(Long id) {
        for (int i = 0; i < people.size(); i++) {
            if (Objects.equals(id, people.get(i).getId())) {
                return people;
            }
        }
        try {
            throw new Notfound("Not found!");
        } catch (Notfound e) {
            return e.getMessage();
        }
    }

    @Override
    public List getAll() {
        return people;
    }

    @Override
    public List sortByName() {
        System.out.println("Write number (1 || 2)");
        String num = new Scanner(System.in).nextLine();
        if (num.equalsIgnoreCase("1")) {
            LinkedList<Person> forOne = new LinkedList<>(people);
            forOne.sort(Person.sortbyName);
            return forOne;
        } else if (num.equalsIgnoreCase("2")) {
            LinkedList<Person> fortwo = new LinkedList<>(people);
            fortwo.sort(Person.sortbyName.reversed());
            return fortwo;
        } else {
            List<String> notfound = new ArrayList<>();
            notfound.add("Write number");
            return notfound;
        }
    }

    @Override
    public List filterByGender() {
        System.out.println("Write number (1 || 2)");
        String num = new Scanner(System.in).nextLine();
        if (num.equalsIgnoreCase("1")) {
            LinkedList<Person> forOne = new LinkedList<>(people);
            forOne.sort(Person.sortByGender);
            return forOne;
        } else if (num.equalsIgnoreCase("2")) {
            LinkedList<Person> fortwo = new LinkedList<>(people);
            fortwo.sort(Person.sortByGender.reversed());
            return fortwo;
        } else {
            List<String> notfound = new ArrayList<>();
            notfound.add("Write number");
            return notfound;
        }
    }

    @Override
    public List clear() {
        people.clear();
        List<String> massive = new ArrayList<>();
        massive.add("Success");
        return massive;
    }
}
