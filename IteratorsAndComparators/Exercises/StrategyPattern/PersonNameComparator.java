package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<PersonStrategy> {


    @Override
    public int compare(PersonStrategy first, PersonStrategy second) {
        if (first.getName().length() == second.getName().length()){
            char letterOfFirst = first.getName().toLowerCase().charAt(0);
            char letterOfSecond = second.getName().toLowerCase().charAt(0);
            return Character.compare(letterOfFirst,letterOfSecond);
        }
        return first.getName().length() - second.getName().length();
    }
}
