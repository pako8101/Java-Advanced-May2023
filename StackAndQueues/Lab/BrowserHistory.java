package JavaAdvanced2023My.StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputUrl = scanner.nextLine();
        String current = null;
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (!inputUrl.equals("Home")) {

            if (inputUrl.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    inputUrl= scanner.nextLine();
                    continue;
                }else {
                    current = stack.pop();
                }
            } else {
                if (current != null) {
                    stack.push(current);
                }
                    current = inputUrl;

            }
            System.out.println(current);
            inputUrl = scanner.nextLine();

        }
    }
}


