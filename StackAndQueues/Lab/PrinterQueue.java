package JavaAdvanced2023My.StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
//                String output = queue.isEmpty()
//                        ? "Printer is on standby"
//                        : "Canceled " + queue.poll();
                String output;
                if (queue.isEmpty()) {
                    output= "Printer is on standby";
                } else {
                    output = "Canceled " + queue.poll();
                }
                System.out.println(output);
            } else {
                queue.offer(input);

            }
            input = scanner.nextLine();
        }
           /* for (String out : queue) {
                System.out.println(out);*/
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}



