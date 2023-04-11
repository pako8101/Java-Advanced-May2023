package JavaAdvanced2023My.StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elemToAdd = num[0];
        int elemToPoll = num[1];
        int elemToPresent = num[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] numToAdd = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < elemToAdd; i++) {
            queue.offer(numToAdd[i]);

        }
        for (int i = 0; i < elemToPoll; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(elemToPresent)) {
            System.out.println("true");

        } else {
//            //int smallest = Integer.MAX_VALUE;
//            for (Integer number : stack) {
////                if (number < minElement) {
////                    number = minElement;
            //int min = Collections.min(stack);
            int minElement = queue.stream().mapToInt(e->e).min().getAsInt();
//

            System.out.println(minElement);
        }
    }
}
