package JavaAdvanced2023My.StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputUrl = scanner.nextLine();
        String current = null;
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        while (!inputUrl.equals("Home")) {
            if (inputUrl.equals("back")) {
                if (backStack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    current = backStack.pop();
                    forwardQueue.push(current);
                    System.out.println(backStack.peek());
                }
            } else if (inputUrl.equals("forward")) {
                if (forwardQueue.isEmpty()) {
                    System.out.println("no next URLs");

                } else {
                    String forwardCurrent = forwardQueue.pop();
                    System.out.println(forwardCurrent);
                    backStack.push(forwardCurrent);
                }
            } else {
                backStack.push(inputUrl);
                System.out.println(inputUrl);
                forwardQueue.clear();

            }
            inputUrl = scanner.nextLine();
        }
    }
}