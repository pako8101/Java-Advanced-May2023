package ExamsAdvanced.ExamPreparationJavaAdvanced15Oktober2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    private static int sum;
    private static int itemWorth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue =    Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstItem = firstBoxQueue.peek();
            int secondItem = secondBoxStack.pop();

            sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                itemWorth += sum;
                firstBoxQueue.poll();
            } else {
                firstBoxQueue.offer(secondItem);
            }
        }
            String emptyBoxOutput = firstBoxQueue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";
            System.out.println(emptyBoxOutput);
            String prayValue = itemWorth >= 90 ? "Wow, your prey was epic! Value: "
                    : "Poor prey... Value: ";
            System.out.println(prayValue + itemWorth);
//            if (firstBoxQueue.isEmpty()) {
//                System.out.println("First magic box is empty.");
//            } else if (secondBoxStack.isEmpty()) {
//                System.out.println("Second magic box is empty.");
//            }
//            if (sum >= 90) {
//                System.out.printf("Wow, your prey was epic! Value: %d", itemWorth);
//            } else {
//                System.out.printf("Poor prey... Value: %d", itemWorth);
//            }
//        }
        }

    }
