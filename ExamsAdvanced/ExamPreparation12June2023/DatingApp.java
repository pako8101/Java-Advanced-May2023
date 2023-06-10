package ExamsAdvanced.ExamPreparation12June2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    private static int matches;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] males = scanner.nextLine().split("\\s+");
        String[] females = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        Arrays.stream(males).mapToInt(Integer::parseInt).forEach(stackMales::push);

        ArrayDeque<Integer> queueFemales = new ArrayDeque<>();
        Arrays.stream(females).mapToInt(Integer::parseInt).forEach(queueFemales::offer);

        while (!queueFemales.isEmpty() && !stackMales.isEmpty()) {
            int femaleValue = queueFemales.poll();
            int maleValue = stackMales.pop();
            if (femaleValue <= 0 || maleValue <= 0) {
                continue;
            }
            if (femaleValue % 25 == 0) {
                queueFemales.poll();
                continue;
            } else if (maleValue % 25 == 0) {
                stackMales.pop();
                continue;
            }
            if (femaleValue == maleValue) {
                matches++;
            } else {
                stackMales.push(maleValue - 2);
            }
        }
        System.out.println("Matches: " + matches);
        System.out.print("Males left: ");
        if (stackMales.isEmpty()) {
            System.out.println("none");
        } else {
            printWithComma(stackMales);
        }
        System.out.print("Females left: ");
        if (queueFemales.isEmpty()) {
            System.out.println("none");
        } else {
            printWithComma(queueFemales);
        }
    }

    private static void printWithComma(ArrayDeque<Integer> numbers) {
        ArrayDeque<String> numbersAsText = new ArrayDeque<>();
        for (int number : numbers) {
            numbersAsText.add(String.valueOf(number));

        }
        System.out.println(String.join(", ", numbersAsText));
    }
}
