package ExamsAdvanced.ExamPreparation10February2022;

import java.util.*;

public class AutumnCocktails {
    private static final int Pear_Sour = 150;
    private static final int The_Harvest = 250;
    private static final int Apple_Hinny = 300;
    private static final int High_Fashion = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new HashMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsQueue::offer);
        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessLevelStack::push);
//        int pearCount = 0, harvestCount = 0, appleCount = 0, fashionCount = 0;
        while (!ingredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {
            int firstIngredient =  ingredientsQueue.poll();
            if (firstIngredient == 0) {
                continue;
            }
            int lastFreshness = freshnessLevelStack.pop();
            int freshnessLevel = firstIngredient * lastFreshness;


            switch (freshnessLevel) {
                case Pear_Sour:
                    int currentPear = cocktails.get("Pear Sour");
                    currentPear++;
                    cocktails.put("Pear Sour", currentPear);
                    //pearCount++;
                    break;
                case The_Harvest:
                    int currentHarvest = cocktails.get("The Harvest");
                    currentHarvest++;
                    cocktails.put("The Harvest", currentHarvest);
                    // harvestCount++;
                    break;
                case Apple_Hinny:
                    int currentApple = cocktails.get("Apple Hinny");
                    currentApple++;
                    cocktails.put("Apple Hinny", currentApple);
                    // appleCount++;
                    break;
                case High_Fashion:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
//                    int currentFashion = cocktails.get("High Fashion");
//                    currentFashion++;
//                    cocktails.put("High Fashion", currentFashion);
                    //  fashionCount++;
                    break;

                default:
                    freshnessLevelStack.pop();
                    Integer ingredient = ingredientsQueue.poll();
                    ingredient += 5;
                    ingredientsQueue.offer(ingredient);
                    break;

            }
//            ingredientsQueue.poll();
//            freshnessLevelStack.pop();
        }
        if (cocktails.get("Pear Sour") > 0
                && cocktails.get("The Harvest") > 0
                && cocktails.get("Apple Hinny") > 0
                && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
//            int leftIngredients = ingredientsQueue.stream().mapToInt(e -> e).sum();
            int sum = 0;
            for (Integer ingredient : ingredientsQueue) {
                 sum += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }
        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }
        if (cocktails.get("The Harvest") > 0) {
            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
        }
        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }
        if (cocktails.get("High Fashion") > 0) {
            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
//            cocktails.entrySet().forEach(entry -> System.out.println("# " + entry.getKey() + " --> " + entry.getValue()));

        }
    }
}