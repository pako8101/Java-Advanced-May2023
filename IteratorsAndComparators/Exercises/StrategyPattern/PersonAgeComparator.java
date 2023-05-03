package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<PersonStrategy> {
    @Override
    public int compare(PersonStrategy first, PersonStrategy second) {
        return first.getAge() - second.getAge();
    }
}
