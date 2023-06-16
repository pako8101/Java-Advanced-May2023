package ExamsAdvanced.JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    private static final int BREAD = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int FRUIT_PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);
        Map<String, Integer> foodsMap = new TreeMap<>();
        foodsMap.put("Bread", 0);
        foodsMap.put("Cake", 0);
        foodsMap.put("Pastry", 0);
        foodsMap.put("Fruit Pie", 0);
        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();
            int sum = liquid + ingredient;
            if (sum == BREAD) {
                foodsMap.put("Bread", foodsMap.get("Bread") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == CAKE) {
                foodsMap.put("Cake", foodsMap.get("Cake") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == PASTRY) {
                foodsMap.put("Pastry", foodsMap.get("Pastry") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == FRUIT_PIE) {
                foodsMap.put("Fruit Pie", foodsMap.get("Fruit Pie") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
            // foodsMap.entrySet().stream().filter(entry -> entry.getValue() > 0);

        }
        System.out.println(foodsMap.containsValue(0) ?
                "Ugh, what a pity! You didn't have enough materials to cook everything." :
                "Wohoo! You succeeded in cooking all the food!");


        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()) {
            System.out.println("none");
        } else {
            String result = liquidsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()) {
            System.out.println("none");
        } else {
            String result = ingredientsStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        foodsMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }

}
//        Predicate<Integer> checkGreater = value->value >0;
//        foodsMap.entrySet().stream().filter(entry -> entry.getValue()>0).forEach(System.out::println);

