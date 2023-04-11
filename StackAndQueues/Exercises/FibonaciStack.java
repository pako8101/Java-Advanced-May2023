package JavaAdvanced2023My.StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FibonaciStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(0l);
        stack.push(1l);
        if (n<2){
            return;
        }
        for (int i = 0; i < n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();
            stack.push(num1);
            stack.push(num2+num1);
        }
        System.out.println(stack.pop());
    }
}
