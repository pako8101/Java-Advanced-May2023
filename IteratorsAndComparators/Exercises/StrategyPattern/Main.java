package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        TreeSet<PersonStrategy> nameSet = new TreeSet<>(new PersonNameComparator());
        TreeSet<PersonStrategy> ageSet = new TreeSet<>(new PersonAgeComparator());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] personData = scanner.nextLine().split(" ");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            PersonStrategy personStrategy = new PersonStrategy(name, age);
            nameSet.add(personStrategy);
            ageSet.add(personStrategy);

        }
        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);


    }
}
