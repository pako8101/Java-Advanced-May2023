package JavaAdvanced2023My.StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();
        ArrayDeque<Character> queueCloseBrackets = new ArrayDeque<>();
        boolean isBalanced = true;
        for (char symbol : brackets.toCharArray()) {
            //char current = brackets.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stackOpenBrackets.push(symbol);
            } else {
                if (stackOpenBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpening = stackOpenBrackets.pop();
                if (symbol == ')' && lastOpening != '(') {
                    isBalanced = false;
                    break;
                } else if (symbol == '}' && lastOpening != '{') {
                    isBalanced = false;
                    break;
                } else if (symbol == ']' && lastOpening != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced && stackOpenBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

