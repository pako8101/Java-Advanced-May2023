package ExamsAdvanced.JavaAdvancedExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    private static int stamatCaffeine = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> energyDrinkQueue = new ArrayDeque<>();
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(caffeineStack::push);

        input = scanner.nextLine();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinkQueue::offer);

        while (!caffeineStack.isEmpty() && !energyDrinkQueue.isEmpty()) {
            int currentDrink = energyDrinkQueue.poll();
            int currentCaffeine = caffeineStack.pop();
            int caffeineCalculate = currentCaffeine * currentDrink;
            if (stamatCaffeine + caffeineCalculate <= 300) {
                stamatCaffeine += caffeineCalculate;
            } else {

                stamatCaffeine -= 30;
                energyDrinkQueue.offer(currentDrink);

                if (stamatCaffeine < 0) {
                    stamatCaffeine = 0;
                }
            }
        }
        if (energyDrinkQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            energyDrinkQueue.forEach(e -> System.out.print(e + ", "));
//            String result = energyDrinkQueue.toString().replaceAll("[\\[\\]]", "");
//            System.out.println(result);
            String result = energyDrinkQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", stamatCaffeine);

    }


}