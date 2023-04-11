package JavaAdvanced2023My.StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elemToPush = num[0];
        int elemToPop = num[1];
        int elemToPresent = num[2];

        //String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numToAdd = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < elemToPush; i++) {
            stack.push(numToAdd[i]);
//            Arrays.stream(input.split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .forEach(e -> stack.push(elemToPush));
        }
        for (int i = 0; i < elemToPop; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(elemToPresent)) {
            System.out.println("true");

        } else {
//            //int smallest = Integer.MAX_VALUE;
//            for (Integer number : stack) {
////                if (number < minElement) {
////                    number = minElement;
            //int min = Collections.min(stack);
            int minElement = stack.stream().mapToInt(e->e).min().getAsInt();
//

                System.out.println(minElement);
            }
        }
    }

