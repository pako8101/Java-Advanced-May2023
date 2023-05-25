package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> alternative = list -> {
            int sum = list.stream().mapToInt(e -> e).sum();
            return sum;
        };


//        Function<List<Integer>, Integer> sum = list -> {
//            int sumNumbers = 0;
//            for (Integer number : list) {
//                sumNumbers += number;
//            }
//            return sumNumbers;
//        };
        System.out.println("Count = " + numbersList.size());
        System.out.println("Sum = " + alternative.apply(numbersList));
    }
}
