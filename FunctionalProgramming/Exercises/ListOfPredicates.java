package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int endOfRange = Integer.parseInt(scanner.nextLine());
        int[] numbersToDivideTo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Predicate<Integer> isDivisible = number -> {
            for (Integer numberToDivideTo : numbersToDivideTo) {
                if (number % numberToDivideTo != 0) {
                    return false;
                }
            }
            return true;
        };
        for (int number = 1; number <= endOfRange; number++) {
            if (isDivisible.test(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
