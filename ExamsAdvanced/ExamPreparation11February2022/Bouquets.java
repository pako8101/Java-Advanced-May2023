package ExamsAdvanced.ExamPreparation11February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    private static int bouquets;
    private static int sum;
    private static int leftFlowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tulipsStack::push);

        input = scanner.nextLine();

        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(daffodilsQueue::offer);
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulips = tulipsStack.peek();
            int daffodils = daffodilsQueue.peek();
            sum = tulips + daffodils;
            if (sum == 15) {
                bouquets++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (sum > 15) {
                tulipsStack.pop();
                tulipsStack.push(tulips - 2);
            } else {
                leftFlowers += sum;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }

        }
        int bouquetsLeftFlowers = leftFlowers / 15;
        bouquets += bouquetsLeftFlowers;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);

        } else {
            System.out.printf("You failed... You need more %d bouquets.\n", 5 - bouquets);

        }

    }
}
