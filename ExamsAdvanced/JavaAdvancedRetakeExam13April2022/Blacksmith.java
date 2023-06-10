package ExamsAdvanced.JavaAdvancedRetakeExam13April2022;

import java.util.*;

public class Blacksmith {
    public static final int Gladius = 70;
    public static final int Shamshir = 80;
    public static final int Katana = 90;
    public static final int Sabre = 110;
    public static int sum;
    public static int swordGaldius;
    public static int swordShamshir;
    public static int swordKatana;
    public static int swordSabre;
    public static int swordsTotal;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();

        String input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        input = scanner.nextLine();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);
        Map<String, Integer> swords = new TreeMap<>();
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steelToOffer = steelQueue.peek();
            int carbonToPush = carbonStack.peek();
            sum = steelToOffer + carbonToPush;
            if (sum == Gladius) {
                swordGaldius++;
                swords.put("Gladius", swordGaldius);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == Shamshir) {
                swordShamshir++;
                swords.put("Shamshir", swordShamshir);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == Katana) {
                swordKatana++;
                swords.put("Katana", swordKatana);
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == Sabre) {
                swordSabre++;
                swords.put("Sabre", swordSabre);
                steelQueue.poll();
                carbonStack.pop();
            } else {
                steelQueue.poll();
                carbonStack.push(carbonStack.pop() + 5);
            }
            swordsTotal = swordGaldius + swordSabre + swordKatana + swordShamshir;
        }
        if (swordsTotal == 0) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.printf("You have forged %d swords.\n", swordsTotal);
        }
        System.out.print("Steel left: ");
        if (steelQueue.isEmpty()) {
            System.out.println("none");
        } else {

            printWithComma(steelQueue);
        }
        System.out.print("Carbon left: ");
        if (carbonStack.isEmpty()) {
            System.out.println(" none");
        } else {

            printWithComma(carbonStack);
        }
        System.out.println();
        swords.forEach((key, value) -> System.out.println(key + ": " + value));
        {
        }
    }

    private static void printWithComma(ArrayDeque<Integer> numbers) {
        ArrayDeque<String> numbersAsText = new ArrayDeque<>();
        for (int number : numbers) {
            numbersAsText.add(String.valueOf(number));

        }
        System.out.print(String.join(", ", numbersAsText));
    }
}
