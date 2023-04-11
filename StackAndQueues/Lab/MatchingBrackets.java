package JavaAdvanced2023My.StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            int current = expression.charAt(i);
            if (current=='('){
                stack.push(i);
            } else if (current==')') {
                int start = stack.pop();
                int end = i;
                String sub = expression.substring(start, end+1);
                System.out.println(sub);
            }
        }
    }
}
