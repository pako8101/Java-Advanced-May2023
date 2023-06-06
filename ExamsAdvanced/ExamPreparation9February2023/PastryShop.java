package ExamsAdvanced.ExamPreparation9February2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop {
    private static final int BISCUIT_VALUE = 25;
    private static final int CAKE_VALUE = 50;
    private static final int PASTRY_VALUE = 75;
    private static final int PIE_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            Integer liquid = liquidsQueue.poll();
            Integer ingredient = ingredientsStack.pop();
            int possiblePastry = liquid + ingredient;

            switch (possiblePastry) {
                case BISCUIT_VALUE:
                    biscuitCount++;
                    break;
                case CAKE_VALUE:
                    cakeCount++;
                    break;
                case PASTRY_VALUE:
                    pastryCount++;
                    break;
                case PIE_VALUE:
                    pieCount++;
                    break;
                default:
                    ingredientsStack.push(ingredient + 3);
                    break;
            }
        }
        if (biscuitCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()) {
            System.out.println("none");
        } else {
            String left = ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(left);
//            System.out.println(liquidsQueue.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredientsStack.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.printf("Biscuit: %d\nCake: %d\nPie: %d\nPastry: %d\n", biscuitCount, cakeCount, pieCount, pastryCount);
    }
}
