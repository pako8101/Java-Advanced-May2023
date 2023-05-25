package FunctionalProgramming.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class SortEvenWith_Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        printListWithComma(numbers);
        // numbers.forEach(n -> System.out.print(n + ", "));

        Collections.sort(numbers);
        printListWithComma(numbers);
        // numbers.forEach(n -> System.out.print(n + ", "));
    }

    private static void printListWithComma(List<Integer> numbers) {
        List<String> numbersAsText = new ArrayList<>();
        for (int number : numbers) {
            numbersAsText.add(String.valueOf(number));

        }System.out.println(String.join(", ", numbersAsText));
    }

}
