package ExamsAdvanced.ExamPreparation10February2022;

import java.util.*;

public class AutumnCocktails {
    private static final int Pear_Sour = 150;
    private static final int The_Harvest = 250;
    private static final int Apple_Hinny = 300;
    private static final int High_Fashion = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new TreeMap<>();
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
            int firstIngredient = ingredientsQueue.peek();
            if (firstIngredient == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int lastFreshness = freshnessLevelStack.peek();
            int totalFreshnessLevel = firstIngredient * lastFreshness;


            switch (totalFreshnessLevel) {
                case Pear_Sour:
                    int currentPear = cocktails.get("Pear Sour");
                    cocktails.put("Pear Sour", currentPear + 1);
                    ingredientsQueue.poll();
                    freshnessLevelStack.pop();
                    break;
                case The_Harvest:
                    int currentHarvest = cocktails.get("The Harvest");
                    cocktails.put("The Harvest", currentHarvest + 1);
                    ingredientsQueue.poll();
                    freshnessLevelStack.pop();
                    break;
                case Apple_Hinny:
                    int currentApple = cocktails.get("Apple Hinny");
                    cocktails.put("Apple Hinny", currentApple + 1);
                    ingredientsQueue.poll();
                    freshnessLevelStack.pop();
                    break;
                case High_Fashion:
                    cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                    ingredientsQueue.poll();
                    freshnessLevelStack.pop();
                    break;

                default:
                    freshnessLevelStack.pop();
                    Integer ingredient = ingredientsQueue.poll();
                    ingredient += 5;
                    ingredientsQueue.offer(ingredient);
                    break;

            }


        }
        System.out.println(cocktails.containsValue(0) ? "What a pity! You didn't manage to prepare all cocktails." :
                "It's party time! The cocktails are ready!");

        if (!ingredientsQueue.isEmpty()) {
            int leftIngredients = ingredientsQueue.stream().mapToInt(e -> e).sum();

            System.out.printf("Ingredients left: %d%n", leftIngredients);
        }
//        if (cocktails.get("Apple Hinny") > 0) {
//            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
//        }
//        if (cocktails.get("High Fashion") > 0) {
//            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
//        }
//        if (cocktails.get("Pear Sour") > 0) {
//            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
//        }
//        if (cocktails.get("The Harvest") > 0) {
//            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
//        }
        cocktails.entrySet().stream().filter(entry -> entry.getValue() > 0)
                .forEach(e -> System.out.println("# " + e.getKey() + " --> " + e.getValue()));
//          cocktails.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
//                          .forEach(e ->  System.out.println("# " + e.getKey() + " --> " + e.getValue()));

//        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
//            if (entry.getValue() > 0) {
//                System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
//            }
//        }

    }


}

