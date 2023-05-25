package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] splitInput = input.split(", ");
        List<Integer> numbers = new ArrayList<>();
        for (String text : splitInput) {
            numbers.add(Integer.parseInt(text));
        }
        printOnlyEven(numbers);
        Collections.sort(numbers);

        printOnlyEven(numbers);
    }

    private static void printOnlyEven(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0 && number!= numbers.size()-1) {
                System.out.print(number + ", ");


            }
        }
    }
}
