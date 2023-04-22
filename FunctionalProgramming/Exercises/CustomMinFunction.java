package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> function =  arr -> {
            int min = Integer.MAX_VALUE;
            for (int num : numbers) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        };
//        Function<int[], Integer> minimum = elements -> Arrays.stream(elements).min().orElse(0);
//        System.out.println(minimum.apply(numbers));
//        Function<int[], Integer> minFunction = elements -> Collections.min(Arrays.stream(elements).boxed().toList());
//        System.out.println(minFunction.apply(numbers));
            int min = function.apply(numbers);

            System.out.println(min);
        }


    public static Integer getMin(int[] numbers) {

        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;

    }
}
