package IteratorsAndComparators.Exercises.ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
//        String createInput = scanner.nextLine();
//        List<String> data = Arrays.stream(createInput.split(" "))
//                .skip(1).collect(Collectors.toList());
//        ListyIterator listyIterator = new ListyIterator(data);
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
