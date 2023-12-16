package main.service.impl;

import main.Gender;
import main.model.Animal;
import main.service.GenericService;

import java.util.*;

public class AnimalServiceImpl implements GenericService {
    List<Animal> animals = new ArrayList<>();
    public static long counter = 0;

    @Override
    public String add(List t) {
        Animal animal = new Animal();
        while (true) {
            System.out.println("Write name: ");
            String name = new Scanner(System.in).nextLine();
            if (name.length() > 2) {
                animal.setName(name);
                break;
            }
        }
        animal.setId(++AnimalServiceImpl.counter);
        while (true) {
            try {
                System.out.println("Write age : ");
                int name = new Scanner(System.in).nextInt();
                if (name > 0 && name < 80) {
                    animal.setAge(name);
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("San jazz!");
                new Scanner(System.in).reset();
            }
        }
        while (true) {
            System.out.println("Write Gender: (Male || Female) ");
            String name = new Scanner(System.in).nextLine();
            if (name.equalsIgnoreCase(Gender.FEMALE.name())) {
                animal.setGender(Gender.FEMALE);
                break;
            } else if (name.equalsIgnoreCase(Gender.MALE.name())) {
                animal.setGender(Gender.MALE);
                break;
            }
        }
        animals.add(animal);
        t.add(animal);
        return "Success!";
    }

    @Override
    public Object getById(Long id) {
        for (int i = 0; i < animals.size(); i++) {
            if (Objects.equals(id, animals.get(i).getId())) {
                return animals;
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
        return animals;
    }

    @Override
    public List sortByName() {
        System.out.println("Write number (1 || 2)");
        String num = new Scanner(System.in).nextLine();
        if (num.equalsIgnoreCase("1")) {
            LinkedList<Animal> forOne = new LinkedList<>(animals);
            forOne.sort(Animal.sortbyName);
            return forOne;
        } else if (num.equalsIgnoreCase("2")) {
            LinkedList<Animal> fortwo = new LinkedList<>(animals);
            fortwo.sort(Animal.sortbyName.reversed());
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
            LinkedList<Animal> forOne = new LinkedList<>(animals);
            forOne.sort(Animal.sortByGender);
            return forOne;
        } else if (num.equalsIgnoreCase("2")) {
            LinkedList<Animal> fortwo = new LinkedList<>(animals);
            fortwo.sort(Animal.sortByGender.reversed());
            return fortwo;
        } else {
            List<String> notfound = new ArrayList<>();
            notfound.add("Write number");
            return notfound;
        }
    }

    @Override
    public List clear() {
        animals.clear();
        List<String> massive = new ArrayList<>();
        massive.add("Success");
        return massive;
    }
}
