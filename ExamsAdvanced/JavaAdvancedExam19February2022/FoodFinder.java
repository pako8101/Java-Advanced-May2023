package ExamsAdvanced.JavaAdvancedExam19February2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .forEach(vowelsQueue::offer);
        input = scanner.nextLine();
        Arrays.stream(input.split("\\s+"))
                .forEach(consonantsStack::push);

        List<String> words = List.of("pear", "flour", "pork", "olive");
        List<String> foundWords = new java.util.ArrayList<>(List.of("____", "____", "____", "____"));
        while (!vowelsQueue.isEmpty() && !consonantsStack.isEmpty()) {

            String vowel = vowelsQueue.poll();
            String consonant = consonantsStack.pop();

            for (int i = 0; i < words.size(); i++) {
                String currentWord = words.get(i);
                StringBuilder emptyWord = new StringBuilder(foundWords.get(i));
                if (currentWord.contains(vowel)) {
                    int vowelIndex = currentWord.indexOf(vowel);
                    emptyWord.setCharAt(vowelIndex, vowel.charAt(0));

                }
                if (currentWord.contains(consonant)) {
                    int consIndex = currentWord.indexOf(consonant);
                    emptyWord.setCharAt(consIndex, consonant.charAt(0));
                }
                foundWords.set(i, emptyWord.toString());
            }
            vowelsQueue.offer(vowel);
        }
        List<String> result = foundWords.stream()
                .filter(word -> !word.contains("_"))
                .collect(Collectors.toList());
        System.out.printf("Words found: %d ", result.size());
        result.forEach(System.out::println);
    }
}

