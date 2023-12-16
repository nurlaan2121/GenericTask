package main;

import main.model.Animal;
import main.model.Person;
import main.service.impl.AnimalServiceImpl;
import main.service.impl.PersonServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Person> people = new ArrayList<>();
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        PersonServiceImpl personService = new PersonServiceImpl();
        while (true) {
            System.out.println("Write (1 for person || 2  for Animal) 0.Exit");
            String action = new Scanner(System.in).nextLine();
            if (action.equalsIgnoreCase("1")) {
                LOOP3:
                while (true) {
                    System.out.println("""
                            1.Create person
                            2.Get by ID
                            3.Get all people
                            4.Sort by name
                            5.Sort by gender
                            6.Clear 
                            0.Exit
                            """);
                    try {
                        int num = new Scanner(System.in).nextInt();
                        switch (num) {
                            case 1 -> {
                                System.out.println(personService.add(people));
                            }
                            case 2 -> {
                                System.out.println("Write ID: ");
                                try {
                                    long number = new Scanner(System.in).nextLong();
                                    System.out.println(personService.getById(number));
                                } catch (InputMismatchException exception) {
                                    System.out.println("San jaz");
                                }
                            }
                            case 3 -> {
                                System.out.println(personService.getAll());
                            }
                            case 4 -> {
                                System.out.println(personService.sortByName());
                            }
                            case 5 -> {
                                System.out.println(personService.filterByGender());
                            }
                            case 6 -> {
                                System.out.println(personService.clear());
                            }
                            case 0 -> {
                                break LOOP3;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Write number!");
                    }

                }
            } else if (action.equalsIgnoreCase("2")) {
                LOOP3:
                while (true) {
                    System.out.println("""
                            1.Create Animal
                            2.Get by ID
                            3.Get all animals
                            4.Sort by name
                            5.Sort by gender
                            6.Clear 
                            0.Exit
                            """);
                    try {
                        int num = new Scanner(System.in).nextInt();
                        switch (num) {
                            case 1 -> {
                                System.out.println(animalService.add(animals));
                            }
                            case 2 -> {
                                System.out.println("Write ID: ");
                                try {
                                    long number = new Scanner(System.in).nextLong();
                                    System.out.println(animalService.getById(number));
                                } catch (InputMismatchException exception) {
                                    System.out.println("San jaz");
                                }
                            }
                            case 3 -> {
                                System.out.println(animalService.getAll());
                            }
                            case 4 -> {
                                System.out.println(animalService.sortByName());
                            }
                            case 5 -> {
                                System.out.println(animalService.filterByGender());
                            }
                            case 6 -> {
                                System.out.println(animalService.clear());
                            }
                            case 0 -> {
                                break LOOP3;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Write number!");
                    }
                }
            } else if (action.equalsIgnoreCase("0")) {
                break;
            }
        }

    }
}