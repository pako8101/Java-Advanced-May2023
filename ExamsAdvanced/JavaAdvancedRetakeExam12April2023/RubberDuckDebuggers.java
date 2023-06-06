package ExamsAdvanced.JavaAdvancedRetakeExam12April2023;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class RubberDuckDebuggers {
    private static int time;
    private static int Darth_Vader_Ducky;
    private static int Thor_Ducky;
    private static int Big_Blue_Rubber_Ducky;
    private static int Small_Yellow_Rubber_Ducky;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> timeValueQueue = new ArrayDeque<>();
        ArrayDeque<Integer> taskSequenceStack = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(timeValueQueue::offer);
        input = scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(taskSequenceStack::push);
        while (!timeValueQueue.isEmpty() && !taskSequenceStack.isEmpty()) {
            int timeValue = timeValueQueue.peek();
            int task = taskSequenceStack.peek();
            time = timeValue * task;
            if (time >= 0 && time <= 60) {
                Darth_Vader_Ducky++;

            } else if (time >= 61 && time <= 120) {
                Thor_Ducky++;

            } else if (time >= 121 && time <= 180) {
                Big_Blue_Rubber_Ducky++;

            } else if (time >= 181 && time <= 240) {
                Small_Yellow_Rubber_Ducky++;

            } else {
                int timeValueToAdd = timeValueQueue.poll();
                timeValueQueue.offer(timeValueToAdd);
                int taskMinus = taskSequenceStack.pop() - 2;
                taskSequenceStack.push(taskMinus);
                continue;
            }
            timeValueQueue.poll();
            taskSequenceStack.pop();


        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.printf("Darth Vader Ducky: %d\n" +
                        "Thor Ducky: %d\n" +
                        "Big Blue Rubber Ducky: %d\n" +
                        "Small Yellow Rubber Ducky: %d\n", Darth_Vader_Ducky, Thor_Ducky,
                Big_Blue_Rubber_Ducky, Small_Yellow_Rubber_Ducky);
        scanner.close();
    }
}
