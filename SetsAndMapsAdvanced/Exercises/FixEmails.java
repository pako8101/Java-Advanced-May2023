package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, String> nameEndEmail = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") &&
                    !email.endsWith(".or") && !email.endsWith(".com")) {
                nameEndEmail.put(input, email);
            }
            input = scanner.nextLine();
            }
            nameEndEmail.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));


        }


    }
