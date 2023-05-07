package JavaAdvanced2023My.StackAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int commandNumber = 0; commandNumber < n; commandNumber++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                textStack.push(currentText.toString());
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);
            } else if (command.startsWith("2")) {
                textStack.push(currentText.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                int textToDelete = currentText.length() - count;
                currentText.delete(textToDelete, currentText.length());
            } else if (command.startsWith("3")) {
                int position = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(position - 1));
            } else if (command.equals("4")) {
                if (!textStack.isEmpty()) {
                    String last = textStack.pop();
                    currentText = new StringBuilder(last);
                }
            }
        }
    }
}
