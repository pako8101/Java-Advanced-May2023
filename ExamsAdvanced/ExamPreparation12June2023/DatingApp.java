package ExamsAdvanced.ExamPreparation12June2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            int femaleValue = queueFemales.peek();
            int maleValue = stackMales.peek();
            if (femaleValue <= 0 ){
                queueFemales.poll();
                continue;
            } else if (maleValue <= 0) {
                stackMales.pop();
              continue;
            }
            if (femaleValue % 25 == 0) {
                queueFemales.poll();
                queueFemales.poll();
                continue;
            } else if (maleValue % 25 == 0) {
                stackMales.pop();
                stackMales.pop();
                continue;
            }
            if (femaleValue == maleValue) {
                matches++;
                stackMales.pop();
                queueFemales.poll();
            } else {
                queueFemales.poll();
                stackMales.push(stackMales.pop() - 2);
            }
        }
        System.out.println("Matches: " + matches);

        System.out.print("Males left: ");
        if (stackMales.isEmpty()) {
            System.out.println("none");
        } else {
           String result =  stackMales.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        System.out.print("Females left: ");
        if (queueFemales.isEmpty()) {
            System.out.println("none");
        } else {
            String result =  queueFemales.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
    }

}
