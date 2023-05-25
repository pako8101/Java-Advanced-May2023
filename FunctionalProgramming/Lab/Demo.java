package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> isEven = number -> number % 2 == 0;

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        numbers.stream().filter(isEven);
        System.out.println(numbers + "");

        BiFunction<Integer,Integer,Integer> sum = (first, second)->first+second;
        System.out.println(sum.apply(5,6));

        BiConsumer<String,Integer> print = (name,age) -> System.out.println(name + "" + age);
        print.accept("Boko ",25);

        BiPredicate<Integer,Integer> divisible = (first, second)-> first%second ==0;
        System.out.println(divisible.test(45,5));
    }
}
