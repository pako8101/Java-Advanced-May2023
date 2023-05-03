package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator listyIterator = null;
        while (!input.equals("END")) {
            String[] commandPArts = input.split(" ");
            String command = commandPArts[0];
            switch (command) {

                case "Create":
                    if (commandPArts.length > 1) {
                        String[] elementArray = Arrays.copyOfRange(commandPArts, 1, commandPArts.length);
                        listyIterator = new ListyIterator(elementArray);
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }

                    break;
            }

            input = scanner.nextLine();
        }

    }
}
