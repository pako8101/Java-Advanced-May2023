package IteratorsAndComparators.Exercises.MoviePlatform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie("Titanic", 15, 10);
        Movie movie2 = new Movie("Lord of the rings", 25, 9);
        Movie movie3 = new Movie("Softuni", 35, 8);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        MovieNameComparator byName = new MovieNameComparator();
        MovieBudgetComparator byBudget = new MovieBudgetComparator();

        movies.sort(byBudget) ;
        movies.sort(byName);

        List<String> list = new ArrayList<>();
        list.add("Asen");
        list.add("Gogooo");
        list.add("Boko");

        list.sort(new StringCompareByLength());
        for (String s: list) {
            System.out.println(s);
        }

    }
}
