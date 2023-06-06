package ExamsAdvanced.JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    private static int sum;
    private static int wreath;
    private static int storeWreath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);
        input = scanner.nextLine();
        Arrays.stream(input.split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int roses = rosesQueue.peek();
            int lilies = liliesStack.peek();
            sum = lilies + roses;
            if (sum == 15) {
                wreath++;
                rosesQueue.poll();
                liliesStack.pop();
            } else if (sum > 15) {
                liliesStack.push(liliesStack.pop() - 2);
            } else {
                storeWreath += sum;
                rosesQueue.poll();
                liliesStack.pop();
            }

        }
        wreath += storeWreath / 15;
        if (wreath >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreath + " wreaths!");
        } else {
            int neededWreath = 5 - wreath;
            System.out.println("You didn't make it, you need " + neededWreath + " wreaths more!");
        }

    }
}
