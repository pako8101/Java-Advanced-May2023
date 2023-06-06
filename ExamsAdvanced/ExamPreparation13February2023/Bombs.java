package ExamsAdvanced.ExamPreparation13February2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    private static final int Datura_Bombs = 40;
    private static final int Cherry_Bombs = 60;
    private static final int Smoke_Decoy_Bombs = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(bombEffectsQueue::offer);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(bombCasingStack::push);

        int datura = 0, cherry = 0, smoke = 0;
        boolean isBombPouchFilled = false;
        while (!bombEffectsQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            Integer effect = bombEffectsQueue.peek();
            Integer casing = bombCasingStack.peek();
            int sum = effect + casing;
            switch (sum) {
                case Datura_Bombs:
                    datura++;
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();

                    break;
                case Cherry_Bombs:
                    cherry++;
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();

                    break;
                case Smoke_Decoy_Bombs:
                    smoke++;
                    bombEffectsQueue.poll();
                    bombCasingStack.pop();

                    break;
                default:
                    bombCasingStack.push(bombCasingStack.pop() - 5);
                    break;
            }


            if (datura >= 3 && cherry >= 3 && smoke >= 3) {
                isBombPouchFilled = true;
                break;
            }
        }
        if (isBombPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (bombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.printf("Cherry Bombs: %d\nDatura Bombs: %d\nSmoke Decoy Bombs: %d\n", cherry, datura, smoke);

    }
}

