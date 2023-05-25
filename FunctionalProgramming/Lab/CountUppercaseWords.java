package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> words = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());


        //List<String> uppercaseWords = new ArrayList<>();
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(isUpperCase).collect(Collectors.toList());
//        for (String word : uppercaseWords) {
//            if (isUpperCase.test(word)){
//                uppercaseWords.add(word);
//            }
//        }
        System.out.println(words.size());
        System.out.println(String.join("\n", words));


    }
}
