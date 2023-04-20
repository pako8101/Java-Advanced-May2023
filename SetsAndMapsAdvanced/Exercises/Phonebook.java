package SetsAndMapsAdvanced.Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, String> phonebook = new HashMap<>();
        while (!input.equals("search")) {
            String[] account = input.split("-");
            String name = account[0];
            String number = account[1];
            phonebook.putIfAbsent(name, number);
            input = scanner.nextLine();
        }
        input= scanner.nextLine();
        while (!input.equals("stop")){
            if (!phonebook.containsKey(input)){
                System.out.printf("Contact %s does not exist.%n", input);
            }else {
                 System.out.println(input + " -> " + phonebook.get(input));

            }

            input= scanner.nextLine();
        }
    }
}
